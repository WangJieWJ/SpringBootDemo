package com.springbootbasic.pojo.shiro;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Title:
 * Description: 权限表
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/9
 */
@Entity
@Table(name = "shiro_permission")
public class ShiroPermission implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`name`")  //MySQL 的 保留字段
    private String name;

    @Column(name = "enname", unique = true)
    private String enName;

    @Column(name = "`desc`")  //MySQL 的 保留字段
    private String desc;

    @Column(name = "delflag")
    private int delFlag;

    @Column(name = "upuserid")
    private Long upUserId;

    @Column(name = "uptime")
    private Date upTime;

    @Column(name = "cruserid")
    private Long crUserId;

    @Column(name = "crtime")
    private Date crTime;

    public ShiroPermission() {
    }

    public ShiroPermission(String name, String enName, String desc, int delFlag, Long upUserId, Date upTime, Long crUserId, Date crTime) {
        this.name = name;
        this.enName = enName;
        this.desc = desc;
        this.delFlag = delFlag;
        this.upUserId = upUserId;
        this.upTime = upTime;
        this.crUserId = crUserId;
        this.crTime = crTime;
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

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    public Long getUpUserId() {
        return upUserId;
    }

    public void setUpUserId(Long upUserId) {
        this.upUserId = upUserId;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
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
