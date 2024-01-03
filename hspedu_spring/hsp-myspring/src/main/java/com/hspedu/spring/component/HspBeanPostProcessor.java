package com.hspedu.spring.component;

import com.hspedu.spring.annotation.Component;
import com.hspedu.spring.processor.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZhouYu
 * @version 1.0
 * 说明
 * 1. 这是我们自己的一个后置处理器
 * 2. 实现了BeanPostProcessor
 * 3. 我们可重写before 和 after方法
 * 4. 在Spring容器中，仍然把HspBeanPostProcessor当做一个Bean对象，要注入到容器
 * 5. @Component 标识
 * 6. 我们要让HspBeanPostProcessor成为真正的后置处理器，需要在容器中加入业务代码
 * 7. 还要考虑多个后置处理器对象注入到容器问题
 */
@Component
public class HspBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        //后置处理器是对容器的创建的bean生效，相当于是可以对多个对象编程，切面编程
        //日志，权限，身份，事务......
        if (bean instanceof Car) {
            System.out.println("这是一个Car对象，我可以处理");
            //((Car) bean)
        }
        System.out.println("后置处理器HspBeanPostProcessor Before调用 bean类型=" + bean.getClass()
                + " bean的名字=" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("后置处理器HspBeanPostProcessor After调用 bean类型=" + bean.getClass()
                + " bean的名字=" + beanName);

        //实现AOP，返回代理对象，即对Bean进行包装
        //1. 先死后活-> 后面我们可以通过注解就可以更加灵活
        if ("smartDog".equals(beanName)) {
            //使用Jdk的动态代理，返回bean的代理对象
            Object proxyInstance = Proxy.newProxyInstance(HspBeanPostProcessor.class.getClassLoader(),
                    bean.getClass().getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args)
                                throws Throwable {
                            System.out.println("method=" + method.getName());
                            Object result = null;
                            //假如我们要进行前置通知的方法是getSum
                            //后面可以通过注解做的更加灵活
                            if ("getSum".equals(method.getName())) {
                                SmartAnimalAspect.showBeginLog();
                                result = method.invoke(bean, args);//执行目标方法
                                //进行返回通知的处理
                                SmartAnimalAspect.showSuccessLog();
                            } else {
                                result = method.invoke(bean, args);//执行目标方法
                            }
                            return result;
                        }
                    });
            //如果bean是需要返回代理对象的,这里就直接return proxyInstance;
            return proxyInstance;
        }
        //如果不需要AOP，返回 bean
        return bean;
    }
}
