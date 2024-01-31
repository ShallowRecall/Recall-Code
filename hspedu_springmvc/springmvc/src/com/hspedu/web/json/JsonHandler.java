package com.hspedu.web.json;

import com.hspedu.web.json.entity.Dog;
import com.hspedu.web.json.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouYu
 * @version 1.0
 */
//@Controller
//@ResponseBody
@RestController
public class JsonHandler {

    /**
     * 解读
     * 1. 目标方法 @ResponseBody，表返回的数据是json格式
     * 2. springmvc底层根据目标方法@ResponseBody，返回指定格式，根据http请求来进行处理
     * 3. 原生的springmvc使用了转换器
     * 4. HttpMessageConverter
     *
     * @return
     */
    @RequestMapping(value = "/json/dog")
    //@ResponseBody
    public Dog getJson() {

        //返回对象
        //springmvc会根据你的设置，转成json格式数据返回
        Dog dog = new Dog();
        dog.setName("大黄狗");
        dog.setAddress("小新的家");
        return dog;
    }

    // 编写方法，以json格式返回多个Dog
    @RequestMapping(value = "/json/dogs")
    //@ResponseBody
    public List<Dog> getJsons() {

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("大黄狗", "小新的家"));
        dogs.add(new Dog("大黄狗2", "小新2的家"));
        dogs.add(new Dog("大黄狗3", "小新3的家"));

        return dogs;
    }


    /**
     * 解读
     * 1. @RequestBody User user 在形参指定了 @RequestBody
     * 2. springmvc就会将提交的json字符串数据填充给指定Javabean
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/save2")
    //@ResponseBody
    public User save2(@RequestBody User user) {
        // 将前台传过来的数据 以json的格式响应回浏览器
        System.out.println("user~= " + user);
        return user;
    }

    //响应用户下载文件的请求
    @RequestMapping(value = "/downFile")
    public ResponseEntity<byte[]> downFile(HttpSession session)
            throws Exception {

        // 构建一个ResponseEntity对象

        //1. 先获取到下载文件的InputStream
        InputStream resourceAsStream =
                session.getServletContext().getResourceAsStream("/img/2.jpg");

        //2. 开辟一个存放文件的byte数组，byte[] 是可以支持二进制数据(图片，视频，音频)
        byte[] bytes = new byte[resourceAsStream.available()];
        //3. 将下载文件的数据，读入byte[]
        resourceAsStream.read(bytes);

        //4. 创建返回的HttpStatus
        HttpStatus httpStatus = HttpStatus.OK;
        //5. 创建 headers
        HttpHeaders headers = new HttpHeaders();
        //指定返回的数据，客户端应当以附件形式处理
        headers.add("Content-Disposition", "attachment;filename=2.jpg");

        ResponseEntity<byte[]> responseEntity =
                new ResponseEntity<>(bytes, headers, httpStatus);
        // 如果出现找不到文件，解决方法 rebuild project -> 重启Tomcat
        return responseEntity;
    }
}
