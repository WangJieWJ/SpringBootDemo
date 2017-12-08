package com.springbootbasic.annotation;

import java.lang.annotation.*;

/**
 * Title:  字段、属性
 * Description:
 * Copyright: 2017 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringBoot
 * Author: 王杰
 * Create Time:2017/12/7 17:43
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldName {

    String fieldValue() default "";

    String constantsValue() default "";
}
