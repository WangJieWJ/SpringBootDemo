package com.springBootBasic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @ApiImplicitParam(),
    })
    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    public String addUser(@RequestParam String username, @RequestParam String password,
                          @RequestParam String salt, @RequestParam String theme,
                          @RequestParam String trueName, @RequestParam String email,
                          @RequestParam String phone, @RequestParam String remarks,
                          @RequestParam Integer gender, @RequestParam Integer delFlag,
                          @RequestParam Long upUserId, @RequestParam Date upTime,
                          @RequestParam Long crUserId,@RequestParam Date crTime,
                          @RequestParam String pic,@RequestParam Integer status){

        return "";
    }
}
