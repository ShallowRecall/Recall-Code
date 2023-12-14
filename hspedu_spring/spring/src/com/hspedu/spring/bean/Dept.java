package com.hspedu.spring.bean;

/**
 * @author ZhouYu
 * @version 1.0
 * 部门
 */
public class Dept {
    private String name;

    public Dept() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                '}';
    }
}
