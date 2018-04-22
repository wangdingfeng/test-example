package com.example.testexample;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author wangdingfeng
 * @version 1.0
 * @create 2018-04-20 15:18
 * @Description 描述
 **/
public class CustomRealm extends AuthorizingRealm {

    Map<String,String> userInfo = new HashMap<>(16);

   {
        userInfo.put("xiaowang","123456");
        super.setName("customRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //从主体传过来的认证中获取用户名
        String username =  (String)principalCollection.getPrimaryPrincipal();
        //从数据库中后去角色
        Set<String> role = getUserInfoByRole(username);

        //获取权限
        Set<String>  permission = getUserInfoByPermission(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo =new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permission);
        simpleAuthorizationInfo.setRoles(role);

        return simpleAuthorizationInfo;
    }

    private Set<String> getUserInfoByPermission(String username) {
        Set<String> permission =new HashSet<>();
        permission.add("user:add");
        permission.add("user:update");
        return permission;
    }

    private Set<String> getUserInfoByRole(String username) {
        Set<String> role =new HashSet<>();
        role.add("admin");
        role.add("manager");

        return role;


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //从主体传过来的认证中获取用户名
        String username =  (String)authenticationToken.getPrincipal();

        //根据用户名获取密码
        String password =userInfo.get(username);
        if(null == password){
            return  null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo =new SimpleAuthenticationInfo("xiaowang",password,"customRealm");

        return simpleAuthenticationInfo;
    }
}
