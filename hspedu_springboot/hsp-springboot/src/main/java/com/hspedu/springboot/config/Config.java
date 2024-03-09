package com.hspedu.springboot.config;

import com.hspedu.springboot.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhouYu
 * @version 1.0
 * @Configuration : 标识一个配置类，充当Spring配置文件/容器
 * 如果该配置类，在springboot扫描的包/子包下，会被注入到Spring容器
 * 在该类中，可以通过@Bean 来注入其它的组件
 */
@Configuration
public class Config {

    /**
     * 1. 通过@Bean的方式，将new出来的Bean对象，放到Spring容器
     * 2. 该bean在Spring容器的name/id 默认就是 方法名
     * 3. 通过方法名，可以得到注入到spring容器中的dog对象
     *
     * @return
     */
    @Bean
    public Dog dog() {
        return new Dog();
    }
}
