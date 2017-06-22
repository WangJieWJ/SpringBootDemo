package com.springbootbasic.dao.repository;

import com.springbootbasic.pojo.shiro.ShiroUser_Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/11
 */
public interface ShiroUserRoleRepository extends JpaRepository<ShiroUser_Role,Long>{

    //TODO
    //待实现的一些特殊查询
}
