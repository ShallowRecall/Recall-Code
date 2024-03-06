package com.hspedu.springboot.config;

import com.hspedu.springboot.bean.Cat;
import com.hspedu.springboot.bean.Dog;
import com.hspedu.springboot.bean.Furn;
import com.hspedu.springboot.bean.Monster;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @author ZhouYu
 * @version 1.0
 */

/**
 * 解读
 * 1. @Configuration 标识这是一个配置类，等价于配置文件
 * 2. 程序员可以通过@Bena 注解注入bean对象到容器
 * 3. 当一个类被 @Configuration 标识，该类-Bean 也会注入容器
 */

/**
 * 1. proxyBeanMethods ：代理 bean 的方法
 * (1) Full(proxyBeanMethods = true) 、【保证每个 @Bean 方法被调用多少次返回的组件都是 单实例的 , 是代理方式】
 * (2) Lite(proxyBeanMethods = false) 【每个 @Bean 方法被调用多少次返回的组件都是新创 建的 , 是非代理方式】
 * (3) 特别说明 : proxyBeanMethods 是在 调用 @Bean 方法 才生效， 因此， 需要先获取 BeanConfig 组件，再调用方法
 * 而不是直接通过 SpringBoot 主程序得到的容器来获 取 bean, 注意观察直接通 过 ioc.getBean() 获取 Bean, proxyBeanMethods 值并没有生效
 * (4) 如何选择 : 组件依赖必须使用 Full 模式默认。如果不需要组件依赖使用 Lite 模
 * (5) Lite 模 也称为轻量级模式，因为不检测依赖关系，运行速度快
 */

/**
 * 解读：
 * 1. @Import 代码 可以看到，可以指定 class的数组，可以注入指定类型的Bean
 * public @interface Import {
 *     Class<?>[] value();
 * }
 * 2. 通过@Import 方式注入了组件，默认组件名字/id就是对应类型的全类名
 */
@Import(value = {Dog.class, Cat.class})
@Configuration
/**
 * @EnableConfigurationProperties({Furn.class})解读
 * 1. 开启Furn配置绑定功能
 * 2. 把Furn组件自动注册到容器中
 */
//@EnableConfigurationProperties({Furn.class})
public class BeanConfig {

    /**
     * 解读
     * 1. @Bean : 就给容器添加组件，就是一个Monster bean
     * 2. monster01() : 默认 你的方法名monster01 作为Bean的名字/id
     * 3. Monster : 注入类型，注入bean的类型时Monster
     * 4. new Monster(200,"牛魔王",500,"疯魔拳") 注入到容器中具体的Bean信息
     * 5. @Bean(name = "monster_nmw") : 在配置、注入Bean指定名字/id monster_nmw
     * 6. 默认是单例注入
     * 7. 通过 @Scope("prototype") 可以每次返回新的对象，就多例.
     */
    //@Bean(name = "monster_nmw")
    @Bean
    //@Scope("prototype")
    public Monster monster01(){
        return new Monster(200,"牛魔王",500,"疯魔拳");
    }

    @Bean(name = "monster_nmw")
    public Cat cat01(){
        return new Cat();
    }

    @Bean
    /**
     * 解读：
     * 1. @ConditionalOnBean(name = "monster_nmw") 表示
     * 2. 当容器中有一个Bean,名字是monster_nmw(类型不做约束) ,就注入dog01这个Dog bean
     * 3. 如果没有 名字是monster_nmw 的Bean，就不注入dog01这个Dog bean
     * 4. 还有很多其它的约束注解
     * 5. @ConditionalOnMissingBean(name = "monster_nmw") 表示在容器中，
     * 没有 名字/id 为monster_nmw 才注入dog01这个Bean
     *
     *6. @ConditionalOnBean(name = "monster_nmw") 也可以放在配置类
     * 表示对该配置类的所有要注入的组件，都进行条件约束。
     *
     */
    @ConditionalOnBean(name = "monster_nmw")
    //@ConditionalOnMissingBean(name = "monster_nmw")
    public Dog dog01(){
        return new Dog();
    }
}
