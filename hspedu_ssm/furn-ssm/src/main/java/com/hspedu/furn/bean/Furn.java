package com.hspedu.furn.bean;



import org.hibernate.validator.constraints.Range;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Furn {
    private Integer id;

    @NotEmpty(message = "请输入家具名")
    private String name;

    @NotEmpty(message = "请输入制造厂商")
    private String maker;

    @NotNull(message = "请输入数字")
    @Range(min = 0,message = "价格不能小于0")
    private BigDecimal price;

    @NotNull(message = "请输入数字")
    @Range(min = 0,message = "销量不能小于0")
    private Integer sales;

    @NotNull(message = "请输入数字")
    @Range(min = 0,message = "库存不能小于0")
    private Integer stock;

    //当创建Furn对象 imgPath 为url时，imgPath 为null时，imgPath 给默认值(默认图片路径)
    private String imgPath = "assets/images/product-image/1.jpg";

    public Furn() {
    }

    public Furn(Integer id, String name, String maker, BigDecimal price, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.maker = maker;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        //解读：
        //如果imgPath 不为null而且是有数据，就设置给 this.imgPath,否则就使用默认值
        //imgPath != null && !imgPath.equals("") => 使用一个工具类方法完成
        /**
         * public static boolean hasTest(@Nullable String str) {
         *          return str != null && !str.isEmpty() && containsText(str);
         *      }
         */
        //StringUtils.hasText(imgPath) 就是要求imgPath 不是 null，而且不是“”，而且不是“       ”
        //该方法会经常使用
        if (StringUtils.hasText(imgPath)) {
            this.imgPath = imgPath;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker == null ? null : maker.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    @Override
    public String toString() {
        return "Furn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maker='" + maker + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}