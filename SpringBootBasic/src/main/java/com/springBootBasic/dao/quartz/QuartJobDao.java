package com.springBootBasic.dao.quartz;

import com.springBootBasic.pojo.quartz.JobInfo;
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
 * Description: 定时任务的操作实体类   使用JDBCTemplate
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/1
 */
@Repository
public class QuartJobDao {

    @Autowired
    @Qualifier("masterJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    private Logger logger = Logger.getLogger(QuartJobDao.class);

    /**
     * 获取数据库中的所有的定时任务
     *
     * @return
     */
    public List<JobInfo> getAllQuartJob() {
        return jdbcTemplate.query("SELECT * FROM job_info WHERE status = '1'", new RowMapper<JobInfo>() {

            @Override
            public JobInfo mapRow(ResultSet resultSet, int i) throws SQLException {
                JobInfo quartJob = new JobInfo();
                quartJob.setId(resultSet.getInt("id"));
                quartJob.setAppName(resultSet.getString("appName"));
                quartJob.setName(resultSet.getString("name"));
                quartJob.setTriggerCron(resultSet.getString("triggerCron"));
                quartJob.setTriggerName(resultSet.getString("triggerName"));
                quartJob.setCrTime(resultSet.getString("crTime"));
                quartJob.setCrUser(resultSet.getString("crUser"));
                quartJob.setStatus(resultSet.getString("status"));
                return quartJob;
            }
        });
    }

    /**
     * 添加定时任务
     * @param quartJob
     * @return
     */
    public int addQuartJob(JobInfo quartJob){
        return jdbcTemplate.update("INSERT job_info(`appName`,`name`,`triggerCron`,`triggerName`,`crTime`,`crUser`,`status`) values(?,?,?,?,?,?,?)",
                new Object[]{quartJob.getAppName(),quartJob.getName(),quartJob.getTriggerCron(),quartJob.getTriggerName(),quartJob.getCrTime(),quartJob.getCrUser(),quartJob.getStatus()});
    }

    /**
     * 删除定时任务(假删除)
     * @param id
     */
    public int delQuartJob(int id){
        return jdbcTemplate.update("UPDATE job_info SET status='2' WHERE id = ?",new Object[]{id});
    }
}
