package com.hspedu.set_;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author ZhouYu
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class LinkedHashSetExercise {
    public static void main(String[] args) {

        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("奥拓", 1000));//ok
        linkedHashSet.add(new Car("奥迪", 300000));//ok
        linkedHashSet.add(new Car("法拉利", 100000000));//ok
        linkedHashSet.add(new Car("奥迪", 300000));//ok
        linkedHashSet.add(new Car("保时捷", 70000000));//ok
        linkedHashSet.add(new Car("奥迪", 300000));//ok

        System.out.println("linkedHashSet=" + linkedHashSet);



    }
}

class Car {
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    //重新equals 和 hashCode
    //当 name 和 price 相同时，就返回相同的 hashCode 值，equals返回true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(price, car.price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
