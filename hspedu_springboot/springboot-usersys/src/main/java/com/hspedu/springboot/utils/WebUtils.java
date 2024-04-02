package com.hspedu.springboot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class WebUtils {

    // 定义一个文件上传的路径
    public static String UPLOAD_FILE_DIRECTORY = "static/images/upload/";

    // 编写方法，生成一个目录-根据当前日期 年/月/日

    public static String getUploadFileDirectory(){
        return UPLOAD_FILE_DIRECTORY + new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    //测试
/*    public static void main(String[] args) {
        System.out.println(WebUtils.getUploadFileDirectory());
    }*/


}
