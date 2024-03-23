package com.hspedu.furn.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author ZhouYu
 * @version 1.0
 * 如果Furn类名和表 furn名字不能对应，可以通过@TableName注解指定表名
 * 如果可以对应上，可以不写
 */
@Data
//@TableName("furn")
public class Furn {

    //这里我们使用@TableId：表主键标识
    //当我们在 private Integer id 上标识了@TableId
    //说明id 对应的就是表的id字段，而且是主键
    //type = IdType.AUTO 主键的类型是自增长
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private String maker;
    private Double price;
    private Integer sales;
    private Integer stock;
    private String imgPath = "assets/images/product-image/1.jpg";

}
