package com.springboot.common;

/**
 * Title: 字符串工具类
 * Description: 常用的字符串操作
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/6 0006.
 */
public class StrUtil {


    public static String toSafeString(Object object) {
        return object == null ? "" : object.toString();
    }

    public static Integer toSafeInteger(Object object) {
        String Str=toSafeString(object);
        if (isEmpty(Str)) {
            return null;
        }
        return Integer.getInteger(Str); //如果发生格式转换失败的问题，就会返回null
    }

    public static Long toSafeLong(Object object){
        String Str=toSafeString(object);
        if(isEmpty(Str)){
            return null;
        }
        return Long.getLong(Str); //如果发生格式转换失败的问题，就会返回null
    }

    public static Double toSafeDouble(Object object){
        String Str=toSafeString(object);
        if(isEmpty(Str)){
            return null;
        }
        try {
            Double returnDouble=Double.parseDouble(Str);
            return returnDouble;
        }catch (NumberFormatException ex){
            return null;
        }
    }

    public static boolean isEmpty(String Str) {
        return Str == null || "".equals(Str);
    }


    public static void main(String[] args) {
        System.out.println(toSafeString(null).equals(""));
        System.out.println(toSafeDouble("jk"));
        System.out.println(toSafeInteger("1232"));

    }

}
