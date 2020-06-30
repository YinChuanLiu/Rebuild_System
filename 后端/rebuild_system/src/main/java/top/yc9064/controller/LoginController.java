package top.yc9064.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/nopower")
    public String nopower(){
        return "没有权限";
    }


    @RequestMapping("/login")
    public String denglu(String username,String password){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装 用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //执行登录的方法 没有异常则通过
        try {
            subject.login(token);
            return "1"; //认证成功
        }catch (UnknownAccountException e){//用户名异常
            System.out.println("用户名异常");
            return "0";
        }catch (IncorrectCredentialsException e){//密码不存
            System.out.println("密码不存zai");

            return "0";
        }

    }

    @RequestMapping("/student/getsid")
    public String getsid(){
        return "20177587";
    }


}
