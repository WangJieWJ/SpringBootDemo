package com.springbootbasic.pojo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Title:
 * Description:
 *
 * 实体类中的@Column字段的不区分大小写
 *  比如说数据库中建表
 *
 *  数据库中的字段名(包括表名)       @Column注解中的name属性(包括@Table注解)
 *  UserRole                            userrole
 *  user_role                           user_role
 *  user_role                           userRole
 *
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/10
 */
@Entity
@Table(name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,name = "`name`")   //MySQL 的 保留字段
    private String name;

    @Column(nullable = false,name = "password")
    private Integer passWord;

    public User(String name, Integer passWord) {
        this.name = name;
        this.passWord = passWord;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassWord() {
        return passWord;
    }

    public void setPassWord(Integer passWord) {
        this.passWord = passWord;
    }
}
