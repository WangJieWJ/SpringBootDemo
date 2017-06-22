package com.springbootbasic.pojo.shiro;

import javax.persistence.*;
import java.util.Date;

/**
 * Title:
 * Description: 角色与权限关联表
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/9
 */
@Entity
@Table(name = "shiro_role_permission")
public class ShiroRole_Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permissionid")
    private int permissionId;

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

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
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
