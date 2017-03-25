package com.springBootBasic.shell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Title:
 * Description: 本地Shell命令执行
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/16
 */
public class LocalShellExecutor {

    public static void main(String[] args) {

        LocalShellExecutor.exec("ping www.taobao.com");
    }

    public static void exec(String cmds){
        try{
            Process process=Runtime.getRuntime().exec(cmds);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
        }catch (Exception e){

        }

    }
}
