package com.hspedu.web.interceptor;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class FurnHandler {

    @RequestMapping(value = "/hi")
    public String hi(){
        System.out.println("--FurnHandler--hi()---");
        return "success";
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        System.out.println("--FurnHandler--hello()---");
        return "success";
    }

    @RequestMapping(value = "/ok")
    public String ok(){
        System.out.println("--FurnHandler--ok()---");
        return "success";
    }

    /*@Test
    public void test(){
        int[] arr=new int[]{5,0,6,7,3,9,1,4};
        int[] index=new int[]{6,0,2,1,3,6,7,0,2,5,4};
        String tel="";
        for (int i:index){
            tel += arr[i];
        }
        System.out.println(tel);
    }*/

}
