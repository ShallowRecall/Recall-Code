package com.hspedu.spring.ioc;

import com.hspedu.spring.annotation.Autowired;
import com.hspedu.spring.annotation.Component;
import com.hspedu.spring.annotation.ComponentScan;
import com.hspedu.spring.annotation.Scope;
import com.hspedu.spring.processor.BeanPostProcessor;
import com.hspedu.spring.processor.InitializingBean;
import org.apache.commons.lang.StringUtils;


import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ZhouYu
 * @version 1.0
 * HspSpringApplicationContext 类的作用类似Spring原生ioc容器
 */
public class HspSpringApplicationContext {
    private Class ConfigClass;

    //定义属性BeanDefinitionMap -> 存放BeanDefinition对象
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap =
            new ConcurrentHashMap<>();
    //定义属性SingletonObject -> 存放单例对象
    private ConcurrentHashMap<String, Object> singletonObjects =
            new ConcurrentHashMap<>();

    //定义一个属性beanPostProcessorList，=> 存放后置处理器
    private List<BeanPostProcessor> beanPostProcessorList =
            new ArrayList<>();

    //构造器
    public HspSpringApplicationContext(Class configClass) {

        //完成扫描指定包
        beanDefinitionBySca(configClass);

        //通过beanDefinitionMap，初始化singletonObject 单例池
        //封装成方法
        //遍历所有的beanDefinitionMap对象
        Enumeration<String> keys = beanDefinitionMap.keys();
        while (keys.hasMoreElements()) {
            //得到beanName
            String beanName = keys.nextElement();
            //通过beanName 得到对应的beanDefinition对象
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            //判断bean是singleton还是prototype
            if ("singleton".equalsIgnoreCase(beanDefinition.getScope())) {
                //将该bean实例放入到singletonObject 集合
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }
        System.out.println("singletonObjects 单例池=" + singletonObjects);
        System.out.println("beanDefinitionMap=" + beanDefinitionMap);

    }

    //该方法完成对指定包的扫描，并将Bean信息封装到BeanDefinition对象，再放入到Map
    public void beanDefinitionBySca(Class configClass) {
        this.ConfigClass = configClass;
        //获取要扫描的包
        //1. 先得到HspSpringConfig配置的@ComponentScan(value = "com.hspedu.spring.component")
        ComponentScan componentScan =
                (ComponentScan) this.ConfigClass.getDeclaredAnnotation(ComponentScan.class);
        //2. 通过componentScan的value=> 即要扫描的包
        String path = componentScan.value();
        System.out.println("要扫描的包= " + path);


        //得到要扫描的包下的所有资源(类.class)
        //1. 得到类的加载器->APP 类加载器
        ClassLoader classLoader =
                HspSpringApplicationContext.class.getClassLoader();
        //2. 通过类的加载器获取到要扫描包的资源url => 类似一个路径
        path = path.replace(".", "/");//一定要把. 替换成 /
        URL resource =
                classLoader.getResource(path);
        System.out.println("resource=" + resource);
        //3. 将要加载的资源(.class) 路径下的文件进行遍历=>io
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                //System.out.println("============================");
                //System.out.println(f.getAbsolutePath());
                String fileAbsolutePath = f.getAbsolutePath();
                // 这里我们只处理.class文件
                if (fileAbsolutePath.endsWith(".class")) {


                    //1. 获取到类名
                    String className =
                            fileAbsolutePath.substring(fileAbsolutePath.lastIndexOf('/') + 1, fileAbsolutePath.lastIndexOf(".class"));
                    //2. 获取类的完整的路径(全类名)
                    //解读 path.replace("/", ".") => com.hspedu.spring.component.
                    String classFullName = path.replace("/", ".") + "." + className;

                    //3. 判断该类是不是需要注入到容器，就看该类是不是有注解 @Component @Service..
                    try {
                        Class<?> clazz = classLoader.loadClass(classFullName);
                        if (clazz.isAnnotationPresent(Component.class)) {

                            //如果该类使用了@Component，说明是Spring bean
                            System.out.println("是一个Spring bean =" + clazz + " 类名=" + className);

                            //说明
                            //1. 为了方便，这里将后置处理器放入到一个ArrayList
                            //2. 如果发现是一个后置处理器，放入到 beanPostProcessorList
                            //3. 在原生的Spring容器中，对后置处理器还是走的getBean，createBean
                            //   ,但是需要我们在singletonObjects中加入相应的业务逻辑


                            //判断当前的这个clazz有没有实现BeanPostProcessor
                            //说明，这里我们不能使用 instanceof 来判断clazz是否实现了BeanPostProcessor
                            //原因：clazz不是一个实例对象，而是一个类对象/clazz，要使用isAssignableFrom
                            //将其当做一个语法理解
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {

                                BeanPostProcessor beanPostProcessor =
                                        (BeanPostProcessor) clazz.newInstance();
                                //将其放入到beanPostProcessorList
                                beanPostProcessorList.add(beanPostProcessor);
                                continue;
                            }

                            //先得到beanName
                            //1. 得到Component注解
                            Component componentAnnotation =
                                    clazz.getDeclaredAnnotation(Component.class);
                            //2. 得到配置的value值,
                            //TODO 如果程序员没有配置value[后面处理]
                            String beanName = componentAnnotation.value();
                            if ("".equals(beanName)) {//如果没有写value

                                //将该类的类名首字母小写作为beanName
                                beanName = StringUtils.uncapitalize(className);
                            }


                            //3.将Bean信息封装到BeanDefinition对象->放入到BeanDefinitionMap
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(clazz);
                            //4. 获取Scope值
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                //如果配置了Scope，获取他配置的值
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            } else {
                                //如果没有配置Scope，就默认的值singleton
                                beanDefinition.setScope("singleton");
                            }

                            //将beanDefinition 对象放入到beanDefinitionMap中
                            beanDefinitionMap.put(beanName, beanDefinition);

                        } else {
                            //如果该类没有使用@Component，说明不是Spring bean
                            System.out.println("不是一个Spring bean =" + clazz + " 类名=" + className);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("==========================================");
        }
    }

    //完成createBean(BeanDefinition beanDefinition) 方法
    //说明，目前先简单实现
    private Object createBean(String beanName, BeanDefinition beanDefinition) {

        //得到Bean的clazz对象
        Class clazz = beanDefinition.getClazz();

        try {
            //使用反射得到实例
            Object instance = clazz.getDeclaredConstructor().newInstance();
            //分析：这里加入依赖注入的业务逻辑

            //1. 遍历当前要创建的对象的所有字段
            for (Field declaredField : clazz.getDeclaredFields()) {

                //2. 判断这个字段是否有@Autowired
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    //处理@Autowired 的required
                    //Autowired annotation = declaredField.getAnnotation(Autowired.class);
                    //annotation.required()=> 然后进行其它处理

                    //3.得到这个字段名称
                    String name = declaredField.getName();
                    //4. 通过getBean方法来获取要组装的对象
                    Object bean = getBean(name);
                    //5. 进行组装
                    declaredField.setAccessible(true);//因为属性是private，需要暴破
                    declaredField.set(instance, bean);
                }
            }

            System.out.println("=========创建好实例===========" + instance);


            //我们在Bean的初始化方法前，调用后置处理器的before方法
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                //在后置处理器的before方法，可以对spring容器的bean进行处理
                //然后返回处理后的bean实例，相当于做了一个前置处理
                //原生Spring容器，比我们这个还要复杂
                Object current =
                        beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
                if (current != null){
                    instance = current;
                }
            }


            //这里判断是否需要执行Bean的初始化方法
            //1. 判断当前创建的Bean对象是否实现了InitializingBean
            //2. instanceof 表示判断某个对象的运行类型是不是某个类型或者
            //   某个类型的子类型
            //3. 这里就使用到接口编程
            if (instance instanceof InitializingBean) {
                //3. 将instance转成InitializingBean类型
                try {
                    ((InitializingBean) instance).afterPropertiesSet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            //我们在Bean的初始化方法后，调用后置处理器的after方法
            //我们在Bean的初始化方法前，调用后置处理器的before方法
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                //在后置处理器的before方法，可以对spring容器的bean进行处理
                //然后返回处理后的bean实例，相当于做了一个后置处理
                Object current =
                        beanPostProcessor.postProcessAfterInitialization(instance, beanName);
                if (current != null) {
                    instance = current;
                }
            }

            System.out.println("-----------------------------------------------------------");
            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        //如果反射创建对象失败
        return null;
    }

    //编写方法getBean(String name),编写方法返回容器对象
    public Object getBean(String name) {

        //加一个判断，传入的beanName是否在beanDefinitionMap中存在...
        if (beanDefinitionMap.containsKey(name)) {//如果存在

            BeanDefinition beanDefinition = beanDefinitionMap.get(name);
            //得到beanDefinition的scope，分别进行处理
            if ("singleton".equalsIgnoreCase(beanDefinition.getScope())) {
                //说明是单例配置，直接从单例池获取
                return singletonObjects.get(name);
            } else {// 如果不是单例的，我们就调用createBean，反射一个对象
                return createBean(name, beanDefinition);
            }
        } else {// 如果不存在
            //抛出一个空指针异常-也可以自定义
            throw new NullPointerException("没有该bean");
        }
    }
}
