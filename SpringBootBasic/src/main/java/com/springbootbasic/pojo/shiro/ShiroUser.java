package com.springbootbasic.pojo.shiro;

import javax.persistence.*;
import java.util.Date;

/**
 * Title:
 * Description: 用户表
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/9
 */
@Entity
@Table(name = "shiro_user")
public class ShiroUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "theme")
    private String theme;

    @Column(name = "truename")
    private String trueName;

    @Column(name = "enname")
    private String enName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "gender")
    private int gender;

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

    @Column(name = "pic")
    private String pic;

    @Column(name = "status")
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShiroUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", theme='" + theme + '\'' +
                ", trueName='" + trueName + '\'' +
                ", enName='" + enName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", remarks='" + remarks + '\'' +
                ", gender=" + gender +
                ", delFlag=" + delFlag +
                ", upUserId=" + upUserId +
                ", upTime=" + upTime +
                ", crUserId=" + crUserId +
                ", crTime=" + crTime +
                ", pic='" + pic + '\'' +
                ", status=" + status +
                '}';
    }
}
