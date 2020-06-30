package top.yc9064.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller

public class TestController {

    @RequestMapping("/admin/upload")
    public void toindex(@RequestParam("xlsfile") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        System.out.println(file);
        System.out.println("收到文件");
        //上传路径保存设置
        /*String path = request.getServletContext().getRealPath("/upload");

        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件保存地址：" + realPath);
        File file_path= new File(  "/" + file.getOriginalFilename());
        file.transferTo(file_path);//传输文件*/

    }

    @RequestMapping("/errorpage")
    public String toerror(){
        return "errorpage";
    }


}
