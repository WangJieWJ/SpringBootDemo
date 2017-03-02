# 使用JDBCTemplate查询返回自定义对象集合

## 1、在Student.java中添加一个Map转换为Student的方法
```
//实体类
    public static List toObject(List<Map> list){
        List students=new ArrayList();
        for(Map map:list){
            Student student=toObject(map);
            if(student != null){
                students.add(student);
            }
        }
        return students;
    }

    public static Student toObject(Map map){
        Student student=new Student();
        student.setXh((String) map.get("xh"));
        student.setXm((String) map.get("xm"));
        student.setMm((String) map.get("mm"));
        student.setBj((String) map.get("bj"));
        student.setSfzh((String) map.get("sfzh"));
        student.setQq((String) map.get("qq"));
        student.setMobile((String) map.get("email"));
        student.setEmail((String)map.get("email"));
        return student;
    }

//dao层代码
    public List findAll() {
        String sql = SELECT * FROM user_info;
        List<Map<String,Object>> lists = jdbcTemplate.queryForList(sq);
        return UserInfo.toObject(lists);
    }

//总结：这种方法能够实现，但是速度相比很慢。
```

## 2、使用JDBCTemplate.query(SQL,RowMapper)方式实现
```
//dao层实现
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

//总结：在其他查询方法中无法重用。
```

## 3、使用RoeMapper实现接口方式,覆盖mapRow方法：
```
//实体类
public class Student implements RowMapper, Serializable{
    @Override
    public UserInfo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Student student = new Student();
        student.setXh(resultSet.getString("xh"));
        student.setXm(resultSet.getString("xm"));
        student.setMm(resultSet.getString("mm"));
        student.setBj(resultSet.getString("bj"));
        student.setEmail(resultSet.getString("email"));
        student.setSfzh(resultSet.getString("sfzh"));
        return student;
    }
}

//dao层实现
public UserInfo getById(Integer id) {
    String sql = SELECT * FROM user_info WHERE id = ?;
    UserInfo userInfo = jdbcTemplate.queryForObject(sql, new UserInfo(), new Object[] { id });
    return userInfo;
}

public List findAll() {
    String sql = SELECT * FROM user_info;
    List userInfos = jdbcTemplate.query(sql, new UserInfo());
    return userInfos;
}
```

## 4、dao层使用
```
   jdbcTemplate.query("SQL",new BeanPropertyRowMapper<Student>());
//spring 提供框架的同时还提供了一种规范，包括命名规范，自动转换就会要求你javabean的成员变量命名符合规
```

# Quart学习
```
JobDetail:真正的任务内容，任务本身是集成Job接口，但是真正的任务是JobBuilder通过反射的方式实例化的
Trigger:触发器，定义任务应当开始的时间，主要分为两类SimpleTrigger,CronTrigger，SimpleTrigger就是简单触发器，CronTrigger主要用于处理quartz表达式定义的任务，比如每个月20号，每个星期一之类的。
Scheduler:计划表,现在我们有了要做的内容，有了要做的时间，接下来，就把这两个内容填充到计划任务Scheduler对象里面，到了时间它就可以自动运行了。
```