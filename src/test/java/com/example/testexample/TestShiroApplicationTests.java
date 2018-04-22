package com.example.testexample;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @author wangdingfeng
 * @version 1.0
 * @create 2018-04-20 14:31
 * @Description 描述
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestShiroApplicationTests {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("xiaowang","123456","admin");
    }


    //认证
    @Test
    public void contextLoads() {
        //构建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //自定义Realm
        CustomRealm customRealm =new CustomRealm();

        //放进用户
        //defaultSecurityManager.setRealm(simpleAccountRealm);
        defaultSecurityManager.setRealm(customRealm);
        //密码加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        customRealm.setCredentialsMatcher(matcher);

        //主体提交认证申请
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject =SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken =new UsernamePasswordToken("xiaowang","123456");
        //登陆认证
        subject.login(usernamePasswordToken);

        System.err.println("========"+subject.isAuthenticated());
        //退出登录
        //subject.logout();
        subject.checkRole("admin");
        subject.checkPermission("user:add");
//        System.out.println(subject.hasRole("admin"));
    }


}
