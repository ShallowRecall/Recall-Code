package com.hspedu.spring.bean;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class Car {
    private Integer id;
    private String name;
    private Double price;


    public Car() {
    }

    public Car(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return "Car{id = " + id + ", name = " + name + ", price = " + price + "}";
    }
}
