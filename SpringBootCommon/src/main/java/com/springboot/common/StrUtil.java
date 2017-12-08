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

    /**
     * 按照字节获取字符串的长度
     * 一个英文字母(不区分大小写)包括英文标点占用一个字节的空间
     * 一个中文汉字包括中文标点占用两个字节的空间
     * @param s 字符串
     * @return 字节长度
     */
    public static int getWordCount(String s) {
        int length = 0;
        if (s == null || "".equals(s.trim())) {
            return length;
        }
        for (int i = 0; i < s.length(); i++) {
            int ascii = Character.codePointAt(s, i);
            if (ascii >= 0 && ascii <= 255) {
                length++;
                continue;
            }
            length += 2;
        }
        return length;
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
//        //读取日志文件，并进行筛选
//        StringBuilder stringBuilder = new StringBuilder();
//        BufferedReader bufferedReader = null;
//        BufferedWriter bufferedWriter = null;
//        try {
//            bufferedReader = new BufferedReader(new FileReader("I:\\会员中心\\会员中心数据测试\\idsuser600000.sql"));
//            String str = null;
//            while ((str = bufferedReader.readLine()) != null) {
//                stringBuilder.append(str.replaceAll("\"", "`")).append("\n");
//                if (stringBuilder.length() > 60000) {
//                    bufferedWriter = new BufferedWriter(new FileWriter("I:\\会员中心\\会员中心数据测试\\idsuser600000_update.sql", true));
//                    bufferedWriter.write(stringBuilder.toString());
//                    bufferedWriter.flush();
//                    stringBuilder = new StringBuilder();
//                }
//            }
//
//            bufferedWriter.write(stringBuilder.toString());
//            bufferedWriter.flush();
//        } catch (IOException e) {
//            try {
//                bufferedReader.close();
//                bufferedWriter.close();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//            e.printStackTrace();
//        }

        System.out.println(getWordCount("你好中国，"));

    }

}
