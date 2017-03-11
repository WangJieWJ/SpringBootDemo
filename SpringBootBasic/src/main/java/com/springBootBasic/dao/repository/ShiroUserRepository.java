package com.springBootBasic.dao.repository;

import com.springBootBasic.pojo.shiro.ShiroUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/10
 */
public interface ShiroUserRepository extends JpaRepository<ShiroUser, Long>{
}
