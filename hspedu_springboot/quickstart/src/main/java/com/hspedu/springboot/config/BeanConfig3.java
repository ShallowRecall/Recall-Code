package com.hspedu.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Configuration
// 导入beans.xml - 就可以获取到beans.xml 中配置bean
@ImportResource(locations = {"classpath:beans.xml", "classpath:beans02.xml"})
public class BeanConfig3 {
}
