package com.hspedu.springboot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Component
@ConfigurationProperties(prefix = "furn01")
//@ToString // 在编译时，生成toString，默认情况下，会生成一个无参构造器
/**
 * 说明：
 * @Data 注解等价使用了 如下注解 @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
 * @RequiredArgsConstructor :
 */
//@Data
//@Getter
//@Setter
//说明：@NoArgsConstructor 在编译时，会生成无参构造器，默认情况下，会生成一个无参构造器
//说明：当我们有其他构造器生成式，如果希望仍然有无参构造器就需要使用@NoArgsConstructor指定一下
//     ,否则就会
@NoArgsConstructor
// 说明：@AllArgsConstructor 在编译时，会生成全参构造器
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Furn {
    private Integer id;
    private String name;
    private Double price;
}
