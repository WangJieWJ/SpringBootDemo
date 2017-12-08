package com.springbootbasic.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Title:
 * Description:
 * Copyright: 2017 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringBoot
 * Author: 王杰
 * Create Time:2017/12/7 19:43
 */
@Component
@Aspect
@Order(1)
public class ControllerAspect {

    private final static Logger logger= LoggerFactory.getLogger(ControllerAspect.class);



}
