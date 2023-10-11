package com.hspedu.array_;

public class ArrayExercise {
    public static void main(String[] args) {
        /*
        案例：自定义Book类，里面包含name和price，按price排序(从大到小)。
        要求使用两种方式排序，有一个 Book[] books = 4 本书对象.

        使用前面的传递 实现Comparator接口匿名内部类，也称为定制排序.
        可以按照 price (1) 从大道小 (2) 从小到大 (3) 按照书名长度从大到小
         */


        Book[] books = new Book[4];
        books[0] = new Book("红楼梦",100);
        books[1] = new Book("金瓶梅新",90);
        books[2] = new Book("青年文摘20年",5);
        books[3] = new Book("java从入门到放弃~",300);
    }
}

class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
}