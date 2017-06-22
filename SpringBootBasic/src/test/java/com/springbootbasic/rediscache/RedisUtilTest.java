package com.springbootbasic.rediscache;

import com.springbootbasic.SpringBootApp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Title:
 * Description: RedisUtil测试类
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootApp.class)
@WebAppConfiguration
public class RedisUtilTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void remove() throws Exception {
        System.out.println("查看是否有某个Key值的");
        Assert.assertEquals(true,stringRedisTemplate.hasKey("aaa"));
    }

}