package com.springboot.common;

import java.io.*;

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
        String Str = toSafeString(object);
        if (isEmpty(Str)) {
            return null;
        }
        return Integer.getInteger(Str); //如果发生格式转换失败的问题，就会返回null
    }

    public static Long toSafeLong(Object object) {
        String Str = toSafeString(object);
        if (isEmpty(Str)) {
            return null;
        }
        return Long.getLong(Str); //如果发生格式转换失败的问题，就会返回null
    }

    public static Double toSafeDouble(Object object) {
        String Str = toSafeString(object);
        if (isEmpty(Str)) {
            return null;
        }
        try {
            Double returnDouble = Double.parseDouble(Str);
            return returnDouble;
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    public static boolean isEmpty(String Str) {
        return Str == null || "".equals(Str);
    }

    public static final String inputStream2String(InputStream in, String encode)
            throws UnsupportedEncodingException, IOException {
        if (in == null)
            return "";

        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n, encode));
        }
        return out.toString();
    }

    public static void main(String[] args) {
        //读取日志文件，并进行筛选
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("I:\\日志文件\\hyb.out"));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.indexOf("来自haierBBS的【非动态】短信登陆") > 0) {
                    stringBuffer.append(str + "\n");
                }
            }

            bufferedWriter = new BufferedWriter(new FileWriter("I:\\日志文件\\Filter_haierBBS_非动态.txt"));
            bufferedWriter.write(stringBuffer.toString());
        } catch (IOException e) {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }


    }

}
