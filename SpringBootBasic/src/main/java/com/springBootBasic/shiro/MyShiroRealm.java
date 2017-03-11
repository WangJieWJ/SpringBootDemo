package com.springBootBasic.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

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

    /**
     * 授权过程
     * Authorization 是获取用户的角色与权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("MyShiroRealm.doGetAuthorizationInfo()");


        return null;
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
        logger.info("MyShiroRealm.doGetAuthenticationInfo()");

        //获取用户的输入的账号
        String userName=(String)token.getPrincipal();
        logger.info("token.getCredentials():  "+token.getCredentials());

        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存


        //明文: 若存在，将此用户存放到登录认证info中，无需自己做密码对比，Shiro会为我们进行密码对比校验
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo("","密码","getName()");

        return authenticationInfo;
    }
}
