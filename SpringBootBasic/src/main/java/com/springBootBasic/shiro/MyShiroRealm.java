package com.springBootBasic.shiro;

import com.springBootBasic.dao.repository.ShiroUserRepository;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Title:
 * Description:  身份校验核心类
 * <p>
 *  Project: SpringBoot
 *  Create User: 王杰
 *  Create Time: 2017/3/9
 */
public class MyShiroRealm extends AuthorizingRealm{

    private Logger logger=Logger.getLogger(MyShiroRealm.class);

    @Autowired
    private ShiroUserRepository shiroUserRepository;

    /**
     * 授权过程
     * Authorization 是获取用户的角色与权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("MyShiroRealm.doGetAuthorizationInfo()");

        System.out.println("正在进行授权操作");

        //TODO
        //实际项目中，这里可以根据实际情况做缓存

        Set<String> roleNames=new HashSet<String>();
        roleNames.add("系统管理员");

        Set<String> permissions=new HashSet<String>();
        permissions.add("添加用户");
        permissions.add("删除用户");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);

        return info;
    }

    /**
     * 认证信息.(身份验证)
     * Authentication 是用来验证用户身份
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken=(UsernamePasswordToken) token;
        logger.info("MyShiroRealm.doGetAuthenticationInfo()");

        //获取用户的输入的账号
        logger.info("当前登录用户为:  "+usernamePasswordToken.getUsername());
        logger.info("开始做登录校验");

        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存

        //TODO
        //待实现的一些


        //明文: 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(usernamePasswordToken.getUsername()
                ,usernamePasswordToken.getPassword(),"MyShiroRealm!!!");

        return authenticationInfo;
    }
}
