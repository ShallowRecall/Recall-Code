package com.hspedu.web.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author ZhouYu
 * @version 1.0
 * 处理文件上传的handler
 */
@Controller
public class FileUploadHandler {

    //编写方法，处理文件上传的请求


    @RequestMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file,
                             HttpServletRequest request,String introduce) throws IOException {

        //接收到提交的文件名
        String originalFilename = file.getOriginalFilename();
        System.out.println("你上传的文件名= " + originalFilename);
        System.out.println("你上传的文件介绍= " + introduce);
        //得到要把上传文件保存到哪个路径[全路径:包括文件名]
        String fileFullPath =
                request.getServletContext().getRealPath("/img/" + originalFilename);
        //创建文件
        File saveToFile = new File(fileFullPath);
        //将上传的文件，转存到saveToFile
        file.transferTo(saveToFile);
        return "success";
    }
}
