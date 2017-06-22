package com.springbootbasic.dao.repository;

import com.springbootbasic.SpringBootApp;
import com.springbootbasic.pojo.shiro.ShiroUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootApp.class)
@WebAppConfiguration
public class ShiroUserRepositoryTest {

    @Autowired
    private ShiroUserRepository shiroUserRepository;

    @Test
    public void test() {
        ShiroUser shiroUser = shiroUserRepository.getShiroUserByUserNameAndPassWord("WangJie1", "123");
        if (shiroUser == null) {
            System.out.println("结果不存在！！！");
        } else {
            System.out.println(shiroUser.toString());
        }
    }
}