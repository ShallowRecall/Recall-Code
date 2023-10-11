package com.hspedu.array_;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortCustom {
    public static void main(String[] args) {


        int[] arr = {1, -1, 8, 0, 20};
        //bubble01(arr);

        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i1 - i2;
            }
        });


        System.out.println("==定制排序后的情况==");
        System.out.println(Arrays.toString(arr));
    }

    //使用冒泡实现排序
    public static void bubble01(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //从小到大
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //结合冒泡 + 定制
    public  static void bubble02(int[] arr, Comparator c){
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //数组的排序由c.compare(arr[j],arr[j+1])返回的值决定
                if (c.compare(arr[j],arr[j+1]) < 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
/*
理解：
c.compare(arr[j],arr[j+1]) > 0 相当于arr[j] - arr[j+1] > 0
public int compare(Object o1, Object o2) ==> public int compare(i1, i2)
==> c.compare(arr[j],arr[j+1])
return i1 - i2; ==> arr[j] - arr[j+1] > 0   --->      arr[i] > arr[j+i]
return i2 - i1; ==> arr[j+1] - arr[j] > 0   --->      arr[j+1] > arr[j]
 */
