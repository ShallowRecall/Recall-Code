package com.hspedu.poly_.polyarr_;

public class PolyArray {
    public static void main(String[] args) {

        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("Recall", 18,100);
        persons[2] = new Student("smith", 19,30.1);
        persons[3] = new Teacher("scott", 30,20000);
        persons[4] = new Teacher("king", 50, 25000);

        //循环遍历多态数组，调用say
        for (int i = 0; i < persons.length; i++) {
            //提示：person[i] 编译类型是Person ，运行类型是根据实际情况由JVM来判断
            System.out.println(persons[i].say());//动态绑定机制
            //类型判断 + 向下转型.
            if (persons[i] instanceof Student){//判断person[i]的运行类型是不是Student
                Student student = (Student) persons[i];//向下转型
                student.study();
                //也可以适用一条语句 ((Student) persons[i]).study();
            }else if (persons[i] instanceof Teacher){
                ((Teacher)persons[i]).Teach();
            }else if (persons[i] instanceof Person){

            }else {
                System.out.println("你的类型有误，请自己检查...");
            }
        }
    }
}
