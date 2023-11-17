package com.hspedu.utils;


/**
 * @author 韩顺平
 * @version 1.0
 */
public class WebUtils {

    /**
     * 将一个字符串数字，转成 int, 如果转换失败，就返回传入 defaultVal
     * @param strNum
     * @param defaultVal
     * @return
     */
    public static int parseInt(String strNum, int defaultVal) {

        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            System.out.println(strNum + " 格式不对，转换失败");
        }

        return defaultVal;
    }


}
