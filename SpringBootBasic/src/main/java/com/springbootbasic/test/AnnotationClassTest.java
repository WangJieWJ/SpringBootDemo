package com.springbootbasic.test;

import com.springbootbasic.annotation.FieldName;
import com.springbootbasic.annotation.TableName;

import java.lang.reflect.Field;

/**
 * Title:
 * Description:
 * Copyright: 2017 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: SpringBoot
 * Author: 王杰
 * Create Time:2017/12/7 18:27
 */
@TableName(tableName = "annotation_class", className = "AnnotationClass")
public class AnnotationClassTest {

    @FieldName(fieldValue = "annotation_field", constantsValue = "annotationField")
    private String annotationFieldTest;

    public static void main(String[] args) {
        Field[] fields = AnnotationClassTest.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldName.class)) {
                FieldName fieldName = field.getAnnotation(FieldName.class);
                System.out.println(fieldName.fieldValue());
                System.out.println(fieldName.constantsValue());
            }
        }
    }
}
