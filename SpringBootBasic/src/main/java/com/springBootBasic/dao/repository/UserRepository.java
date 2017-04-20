package com.springBootBasic.dao.repository;

import com.springBootBasic.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Title:
 * Description: JPA ORM框架
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/10
 */
public interface UserRepository extends JpaRepository<User, Long> {

    //TODO
    //待实现的一些特殊查询

//    /**
//     * 通过名字相等查询，参数为name
//     * 相当于JPQL：select u from User u where u.name= ?1
//     * @param name
//     * @return
//     */
//    List<User> findByName(String name);
//
//    /**
//     * 通过名字like查询，参数为name
//     * 相当于JPQL：select u from User u where u.name like ?1
//     */
//    List<User> findByNameLike(String name);
//
//    /**
//     * 通过名字和地址查询，参数为name和address
//     * @param name
//     * @param address
//     * @return
//     */
//    List<User> findByNameAndAddress(String name,String address);
}
