package com.hspedu.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 * @Controller 表示该类是一个控制器Controller，通常这个类是一个Servlet
 */
@Controller
public class UserAction {
    //xml配置 ref
    //说明：@Autowired
    //1). 在IOC容器中查找待装配的组件的类型，如果有唯一的bean匹配(类型)，则使用该bean装配
    //2). 如待装配的类型对应的bean在IOC容器中有多个，则使用待装配的属性的属性名作为id值再进行查找，
    //    找到就装配，找不到就抛异常
    //@Autowired


    //说明: @Resource
    //1)@Resource 有两个属性是比较重要的,分是 name 和 type,Spring 将@Resource 注解的name 属性解析为 bean 的名字,
    //  而 type 属性则解析为 bean 的类型.所以如果使用 name 属 性,则使用 byName 的自动注入策略,而使用 type 属性时则使用 byType 自动注入策略
    //  比如@Resource(name = "userService") 表示转配 id = userService对象
    //  比如@Resource(type = UserService.class) 表示按照UserService.class类型进行装配，这时要求容器中只能有一个这样类型的对象
    //2)如果@Resource 没有指定 name 和 type ,则先使用byName注入策略,
    //  如果匹配不上, 再使用 byType 策略, 如果都不成功，就会报错


    //===================================
    //说明：@Autowired + @Qualifier
    //@Autowired + @Qualifier(value = "userService02") 组合也可以完成指定 name/id 来进行自动装配
    //指定id进行组装，也可以使用@Autowired 和 @Qualifier(value = "userService02")
    // 这时，是装配的 id=userService02 , 需要两个注解都需要写上
    @Resource(name = "userService")
    private UserService userService;

    public void sayOk() {
        System.out.println("UserAction 的sayOK()");
        System.out.println("userAction 装配的 userService属性=" + userService);
        userService.hi();
    }
}
