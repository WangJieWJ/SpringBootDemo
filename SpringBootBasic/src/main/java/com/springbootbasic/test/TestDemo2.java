package com.springbootbasic.test;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/4/25
 */
public class TestDemo2 {

    public static void main(String[] args) {
        System.out.println(unzipString(2, "ad"));

    }

    public static String unzipString(int k, String enc) {

        String returnStr = "";
        String temp = "";
        if (enc.indexOf("[") != -1) {
            int firstIndex = enc.indexOf("[");
            int lastIndex = enc.lastIndexOf("]");
            temp += enc.substring(0, firstIndex - 1);
            temp += unzipString(Integer.parseInt(enc.substring(firstIndex - 1, firstIndex)), enc.substring(firstIndex + 1, lastIndex));
            if (lastIndex < enc.length() - 1) {
                temp += enc.substring(lastIndex + 1);
            }
        } else {
            temp = enc;
        }

        for (int i = 0; i < k; i++) {
            returnStr += temp;
        }

        return returnStr.toString();
    }
}
