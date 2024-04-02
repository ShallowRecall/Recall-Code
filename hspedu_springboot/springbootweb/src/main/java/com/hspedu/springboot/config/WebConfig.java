package com.hspedu.springboot.config;

import com.hspedu.springboot.bean.Car;
import com.hspedu.springboot.bean.Monster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ZhouYu
 * @version 1.0
 */

/**
 * @Configuration(proxyBeanMethods = false)
 * 1. 表示 WebConfig 是一个配置类
 * 2. proxyBeanMethods = false 使用Lite模式
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig {

    // 注入bean WebMvcConfigurer
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addFormatters(FormatterRegistry registry) {
                /**
                 * 解读
                 * 1. 在addFormatters 方法中，增加一个自定义的转换器
                 * 2. 增加自定义转换器 String -> Car
                 * 3. 增加的自定义转换器会注册到 converters 容器中
                 * 4. converters 底层结构是 ConcurrentHashMap 内置有124转换器
                 */
                registry.addConverter(new Converter<String, Car>() {
                    @Override
                    public Car convert(String source) {//source就是 传入的字符串
                        //这里就加入自定义的转换业务代码
                        if (!ObjectUtils.isEmpty(source)) {

                            Car car = new Car();
                            String[] split = source.split(",");
                            car.setName(split[0]);
                            car.setPrice(Double.parseDouble(split[1]));
                            return car;
                        }
                        return null;
                    }
                });

                // 换种写法来注册自定义转换器-方便理解

               /* //1. 先创建自定义转换器
                Converter<String, Car> hspConverter = new Converter<String, Car>() {
                    @Override
                    public Car convert(String source) {//source就是 传入的字符串
                        //这里就加入自定义的转换业务代码
                        if (!ObjectUtils.isEmpty(source)) {

                            Car car = new Car();
                            String[] split = source.split(",");
                            car.setName(split[0]);
                            car.setPrice(Double.parseDouble(split[1]));
                            return car;
                        }
                        return null;
                    }
                };

                //还可以增加更多的装换器

                // 第2个自定义转换器
                Converter<String, Monster> hspConverter2 = new Converter<String, Monster>() {
                    @Override
                    public Monster convert(String source) {//source就是 传入的字符串
                        return null;
                    }
                };

                // 第2个自定义转换器
                Converter<String, Car> hspConverter3 = new Converter<String, Car>() {
                    @Override
                    public Car convert(String source) {//source就是 传入的字符串
                        System.out.println("source-" + source);
                        return null;
                    }
                };

                //2. 添加转换器到converters
                registry.addConverter(hspConverter);
                registry.addConverter(hspConverter2);
                registry.addConverter(hspConverter3);*/
            }
        };
    }
}
