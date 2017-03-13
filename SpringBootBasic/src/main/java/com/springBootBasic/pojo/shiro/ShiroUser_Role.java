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

    @Column(name = "userid")
    private Long userId;

    @Column(name = "roleid")
    private int roleId;

    @Column(name = "cruserid")
    private Long crUserId;

    @Column(name = "crtime")
    private Date crTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Long getCrUserId() {
        return crUserId;
    }

    public void setCrUserId(Long crUserId) {
        this.crUserId = crUserId;
    }

    public Date getCrTime() {
        return crTime;
    }

    public void setCrTime(Date crTime) {
        this.crTime = crTime;
    }
}
