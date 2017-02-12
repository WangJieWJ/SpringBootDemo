package com.springBootBasic.service;

import com.alibaba.fastjson.JSON;
import com.springBootBasic.dao.TestDao;
import com.springBootBasic.pojo.Student;
import com.springBootBasic.redisCache.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/8 0008
 */
@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private RedisUtil redisUtil;

    private Logger logger = Logger.getLogger(TestService.class);

    /**
     * 通过学生的学号查找学生信息
     *
     * @param xh
     * @return
     */
    public Student getStudentByXH(String xh) {

        /**
         * 获取数据的步骤：
         * 1、先从redis数据库中查找是否有数据，如果有数据就直接返回，如果没有数据就进行第二步
         * 2、到MySQL数据库中查询，查询到的数据之后，向redis中主动添加数据，并返回。
         *
         * update 20170210：将对象的保存 修改为 保存序列化之后的字符串
         */
        if (redisUtil.exists(xh)) {
            logger.info("从Redis数据库中获得");
//            List<String> list = redisUtil.get_List(xh, 0, -1);
//            Student student = Student.toObject(list);
            String student_Str=redisUtil.get_Str(xh);
            Student student= JSON.parseObject(student_Str,Student.class);
            return student;
        } else {
            logger.info("从MySQL数据库中获得");
            Student student = testDao.getStudentByXH(xh);
            if (student != null) {
//                redisUtil.set_List(xh, Student.toObjecet(student));
                redisUtil.set_Str(xh,JSON.toJSONString(student));
            }
            return student;
        }
    }

}
