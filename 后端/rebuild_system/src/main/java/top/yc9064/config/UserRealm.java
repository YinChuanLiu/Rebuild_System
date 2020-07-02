package top.yc9064.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import top.yc9064.pojo.Student;
import top.yc9064.pojo.Teacher;
import top.yc9064.service.StudentService;
import top.yc9064.service.TeacherService;

public class UserRealm  extends AuthorizingRealm {

    @Autowired
    private StudentService studentServiceImpl;
    @Autowired
    private TeacherService teacherServiceImpl;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Subject subject = SecurityUtils.getSubject();
        if("teacher".equals(subject.getSession().getAttribute("nowUser"))){
            Teacher teacher = (Teacher) subject.getPrincipal();
            System.out.println(teacher.getRootpower());
            info.addStringPermission(teacher.getRootpower());
        }

        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //伪造数据库数据
        //String DB_password = "123456";

        //前端用户的信息
        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
        Subject subject = SecurityUtils.getSubject();
        Student studentByID = studentServiceImpl.getStudentByID(usertoken.getUsername());
        Teacher teacherByID = teacherServiceImpl.getTeacherByID(usertoken.getUsername());
        String DB_pwd = "";
        Object obj=null;
        if(studentByID==null&&teacherByID==null){
            System.out.println("都是null");
            return null; //会抛出异常  UnknownAccountException
        }else {
            if(studentByID!=null){
                DB_pwd=studentByID.getPwd();
                subject.getSession().setAttribute("nowUser","student");
                obj=studentByID;
            }else {
                    DB_pwd = teacherByID.getPwd();
                    subject.getSession().setAttribute("nowUser","teacher");
                    obj=teacherByID;

            }

        }

        //密码认证
        return new SimpleAuthenticationInfo(obj,DB_pwd,"");
    }
}
