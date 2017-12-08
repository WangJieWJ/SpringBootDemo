package com.springbootbasic.annotation;

import java.lang.annotation.*;

/**
 * Title: 表、类
 * Description:
 * Copyright: 2017 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringBoot
 * Author: 王杰
 * Create Time:2017/12/7 17:40
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TableName {

    String tableName() default "";

    String className() default "";
}
