package com.hspedu.springboot.mybatis.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Monster {
    private Integer id;
    private Integer age;
    //这里可以通过注解来解决时区问题
    //GMT 就是格林尼治标准时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthday;
    private String email;
    private String name;
    private String gender;
    private Double salary;
}
