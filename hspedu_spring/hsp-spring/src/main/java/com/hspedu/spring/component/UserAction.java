package com.hspedu.spring.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author ZhouYu
 * @version 1.0
 * 就是一个Controller
 */
//也可以使用@Controller
//在默认情况下，我们配置的@Component @Controller @Service @Repository 是单例的
//@Scope(value = "prototype") 表示以多实例形式，返回UserAction bean
//思考：Spring容器底层如何实现
@Component
@Scope(value = "prototype")
public class UserAction {
}
