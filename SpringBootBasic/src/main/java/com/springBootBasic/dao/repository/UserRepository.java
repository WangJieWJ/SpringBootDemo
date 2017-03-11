package com.springBootBasic.dao.repository;

import com.springBootBasic.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Title:
 * Description: JPA ORM框架
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/10
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
