package com.springBootBasic.pojo.shiro;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Title:
 * Description: 用户与角色关联表
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/9
 */
@Entity
@Table(name = "shiro_user_role")
public class ShiroUser_Role {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "roleId")
    private int roleId;

    @Column(name = "crUserId")
    private int crUserId;

    @Column(name = "crTime")
    private Date crTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getCrUserId() {
        return crUserId;
    }

    public void setCrUserId(int crUserId) {
        this.crUserId = crUserId;
    }

    public Date getCrTime() {
        return crTime;
    }

    public void setCrTime(Date crTime) {
        this.crTime = crTime;
    }
}
