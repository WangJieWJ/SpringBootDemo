package com.springBootBasic.dao.repository;

import com.springBootBasic.SpringBootApp;
import com.springBootBasic.pojo.shiro.ShiroPermission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootApp.class)
@WebAppConfiguration
public class ShiroPermissionRepositoryTest {

    @Autowired
    private ShiroPermissionRepository shiroPermissionRepository;

    @Test
    public void testsave(){
        ShiroPermission shiroPermission=new ShiroPermission();
        shiroPermission.setName("删除用户");
        shiroPermission.setEnName("DeleteUser");
        shiroPermission.setDelFlag(0);
        shiroPermission.setDesc("管理员删除用户");

        ShiroPermission shiroPermission1=shiroPermissionRepository.save(shiroPermission);
        Assert.assertEquals(shiroPermission.getName(),shiroPermission1.getName());
        Assert.assertEquals(shiroPermission.getEnName(),shiroPermission1.getEnName());
        Assert.assertEquals(shiroPermission.getDesc(),shiroPermission1.getDesc());
        System.out.println(shiroPermission1.getUpTime());
    }
}