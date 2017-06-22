package com.springbootbasic.dao;

import com.springbootbasic.pojo.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/8 0008
 */
@Repository
public class TestDao {

    @Autowired
    @Qualifier("masterJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    private Logger logger=Logger.getLogger(TestDao.class);

    /***
     * 通过学号查找一个学生的全部信息
     * @param xh
     * @return
     */
    public Student getStudentByXH(String xh){
        Student student=new Student();
        String SQL="SELECT * FROM t_xs WHERE xh = ?";
        try{
            List<Student> list=jdbcTemplate.query(SQL, new RowMapper<Student>() {
                @Override
                public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                    Student student1=new Student();
                    student1.setXh(resultSet.getString("xh"));
                    student1.setXm(resultSet.getString("xm"));
                    student1.setMm(resultSet.getString("mm"));
                    student1.setBj(resultSet.getString("bj"));
                    student1.setEmail(resultSet.getString("email"));
                    student1.setSfzh(resultSet.getString("sfzh"));
                    student1.setQq(resultSet.getString("qq"));
                    student1.setMobile(resultSet.getString("mobile"));
                    return student1;
                }
            }, new Object[]{xh});
            return list.get(0);
        }catch (Exception e){
            logger.error("数据库查询出错"+e);
            return null;
        }
    }

}
