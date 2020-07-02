package top.yc9064.config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        //设置安全管理器
        bean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<>();
        /*
            anno：无需认证
            authc： 必须认证
            user： 必须拥有 记住我功能 才能用
            perms： 拥有 对某个资源的权限 才能访问
            role： 拥有 某个角色权限 才能访问
         */

        //访问student下的资源 必须登录
        map.put("/student/**","authc");
        //map.put("/teacher/**","role[tea]");
        bean.setFilterChainDefinitionMap(map);

        bean.setLoginUrl("/nopower");

        return bean;
    }


    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    @Bean(name = "userRealm")  //其实默认 就是 方法名userRealm 了 写上了更清楚而已
    public UserRealm userRealm(){
        return new UserRealm();
    }




}
