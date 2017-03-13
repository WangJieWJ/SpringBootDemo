package com.springBootBasic.dao.repository;

import com.springBootBasic.pojo.shiro.ShiroPermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/11
 */
public interface ShiroPermissionRepository extends JpaRepository<ShiroPermission,Long>{

    //TODO
    //待实现的一些特殊查询
}
