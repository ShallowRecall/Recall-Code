package com.hspedu.override_;

public class OverrideExercise {
    public static void main(String[] args) {
        Person recall = new Person("Recall", 19);
        System.out.println(recall.say());
        Student shallowRecall = new Student("ShallowRecall", 20, 1, 99.99);
        System.out.println(shallowRecall.say());
    }
}

