package com.springBootBasic.pojo.shiro;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Title:
 * Description: 角色表
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/9
 */
@Entity
@Table(name = "shiro_role")
public class ShiroRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "enName", unique = true)
    private String enName;

    @Column(name = "remark")
    private String remark;

    @Column(name = "upUserId")
    private int upUserId;

    @Column(name = "upTime")
    private Date upTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getUpUserId() {
        return upUserId;
    }

    public void setUpUserId(int upUserId) {
        this.upUserId = upUserId;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
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
