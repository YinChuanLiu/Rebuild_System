package top.yc9064.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {


    @RequestMapping("/teacher/gettid")
    public String gettid(){
        return "给你老师工号123654" ;
    }


    @RequestMapping("/rootteacher/allotcourse")
    public String allotcourse(){
        return "教研室主任的操作-->分配课程" ;
    }
}
