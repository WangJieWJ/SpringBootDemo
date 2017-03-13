package com.springBootBasic.controller;

import com.springBootBasic.pojo.shiro.ShiroUser;
import com.springboot.common.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/12
 */
@Api(value = "Shiro",description = "Shiro测试")
@RestController
public class ShiroController {

    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "salt",value = "盐",required =true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "theme",value = "主题",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "trueName",value = "真实姓名",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "email",value = "邮箱",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "phone",value = "电话",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "remarks",value = "备注",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "gender",value = "性别(1:男,2:女)",required = true,dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "delFlag",value = "是否删除(0:正常,1:删除)",required = true,dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "upUserId",value = "更新人ID",required = true,dataType = "Long",paramType = "query"),
            @ApiImplicitParam(name = "upTime",value = "更新时间(yyyy-MM-dd)",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "crUserId",value = "创建人ID",required = true,dataType = "Long",paramType = "query"),
            @ApiImplicitParam(name = "crTime",value = "创建时间(yyyy-MM-dd)",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pic",value = "头像地址",required = true,dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "status",value = "状态",required = true,dataType = "int",paramType = "query")
    })
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public String addUser(@RequestParam String username, @RequestParam String password,
                          @RequestParam String salt, @RequestParam String theme,
                          @RequestParam String trueName, @RequestParam String email,
                          @RequestParam String phone, @RequestParam String remarks,
                          @RequestParam Integer gender, @RequestParam Integer delFlag,
                          @RequestParam Long upUserId, @RequestParam String upTime,
                          @RequestParam Long crUserId,@RequestParam String crTime,
                          @RequestParam String pic,@RequestParam Integer status){

        ShiroUser shiroUser=new ShiroUser();

        shiroUser.setUsername(username);
        shiroUser.setPassword(password);
        shiroUser.setSalt(salt);
        shiroUser.setTheme(theme);
        shiroUser.setTrueName(trueName);
        shiroUser.setEmail(email);
        shiroUser.setPhone(phone);
        shiroUser.setRemarks(remarks);
        shiroUser.setGender(gender);
        shiroUser.setDelFlag(delFlag);
        shiroUser.setCrUserId(crUserId);
        shiroUser.setCrTime(DateUtil.getFormatDate("yyyy-MM-dd",crTime));
        shiroUser.setUpUserId(upUserId);
        shiroUser.setUpTime(DateUtil.getFormatDate("yyyy-MM-dd",upTime));
        shiroUser.setPic(pic);
        shiroUser.setStatus(status);

        return shiroUser.toString();
    }


    @ApiOperation(value = "测试")
    @RequestMapping(value = "Test",method = RequestMethod.GET)
    public String getTest(){
        Subject subject= SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken("用户名","密码");
        subject.login(usernamePasswordToken);

        String result="";
        if(subject.isAuthenticated()){
            result="已经登录";
        }else{
            result="未登录";
        }
        return result;
    }
}
