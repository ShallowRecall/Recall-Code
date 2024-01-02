package com.hspedu.spring.component;

import com.hspedu.spring.annotation.Component;
import com.hspedu.spring.processor.BeanPostProcessor;

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
        if (bean instanceof Car){
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
        return bean;
    }
}
