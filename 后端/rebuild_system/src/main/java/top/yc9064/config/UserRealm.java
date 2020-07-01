package top.yc9064.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import top.yc9064.pojo.Student;
import top.yc9064.service.StudentService;

public class UserRealm  extends AuthorizingRealm {

    @Autowired
    private StudentService studentServiceImpl;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了授权");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //伪造数据库数据
        //String DB_password = "123456";

        //前端用户的信息
        UsernamePasswordToken usertoken = (UsernamePasswordToken) token;

        Student studentByID = studentServiceImpl.getStudentByID(usertoken.getUsername());

        if(studentByID==null){
            return null; //会抛出异常  UnknownAccountException
        }

        //密码认证
        return new SimpleAuthenticationInfo("",studentByID.getPwd(),"");
    }
}
