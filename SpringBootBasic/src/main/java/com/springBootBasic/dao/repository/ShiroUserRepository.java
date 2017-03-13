package com.springBootBasic.dao.repository;

import com.springBootBasic.pojo.shiro.ShiroUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/10
 */
public interface ShiroUserRepository extends JpaRepository<ShiroUser, Long>{

    /**
     * 通过用户名和密码来查询当前登录用户的信息
     * @param username
     * @param password
     * @return
     */
    @Query(value = "SELECT * FROM shiro_user where username = ?1 and password = ?2",nativeQuery = true)
    ShiroUser getShiroUserByUserNameAndPassWord(String username,String password);


    //TODO
    //待实现的一些特殊查询
}
