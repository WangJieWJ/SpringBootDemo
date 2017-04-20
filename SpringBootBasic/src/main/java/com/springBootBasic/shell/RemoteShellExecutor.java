package com.springBootBasic.shell;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import ch.ethz.ssh2.log.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title:
 * Description: 远程的Shell脚本
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/16
 */
public class RemoteShellExecutor {

    private Logger logger = new Logger(RemoteShellExecutor.class);
    private Connection connection;
    /**
     * 远程机器IP
     */
    private String ip;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    private String charset = Charset.defaultCharset().toString();

    private static final int TIME_OUT = 1000 * 5 * 60;

    /**
     * 构造函数
     *
     * @param ip IP
     * @param userName 用户名
     * @param passWord 密码
     */
    private RemoteShellExecutor(String ip, String userName, String passWord) {
        this.ip = ip;
        this.userName = userName;
        this.passWord = passWord;
    }

    /**
     * 登录
     *
     * @return 是否能登录成功，可以用来测试用户名和密码是否正确
     * @throws IOException 如果无法正常登录，抛出抛出异常
     */
    private boolean login() throws IOException {
        connection = new Connection(ip);
        connection.connect();
        return connection.authenticateWithPassword(userName, passWord);
    }

    private int exec(String cmds) throws IOException {
        InputStream stdOut = null;
        InputStream stdErr = null;
        String outStr;
        String outErr;
        int ret = -1;
        try {
            if (login()) {
                Session session = connection.openSession();
                session.execCommand(cmds);

                stdOut = new StreamGobbler(session.getStdout());
                outStr = processStream(stdOut, charset);

                stdErr = new StreamGobbler(session.getStderr());
                outErr = processStream(stdErr, charset);

                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);

                System.out.println("--------------------------------");

                //通过location   正则进行分割
//                System.out.println("outStr=" + outStr);
//                String[] array=outStr.split("loca");


                //Split

                //Matcher
                //Pattern

                //通过location   正则获取
                String regEx="(?:location +)([\\d/a-zA-Z.]+)";
                Pattern pat=Pattern.compile(regEx);
                Matcher mat=pat.matcher(outStr);
                StringBuilder stringBuffer=new StringBuilder("   ");
                while (mat.find()){
                    stringBuffer.append(mat.group(1)).append("   ");
                }

                outStr=stringBuffer.toString();


                System.out.println("--------------------------------");
                System.out.println("开始将接收到的数据转换为可识别的文件夹名称");

                System.out.println("结束将接收到的数据转换为可识别的文件夹名称");
                System.out.println(outStr);
                System.out.println("outErr=" + outErr);
                ret = session.getExitStatus();
            } else {
                logger.log(1, "登录远程机器失败" + ip);
            }
        }finally {
            if(connection != null){
                connection.close();
            }
            IOUtils.closeQuietly(stdOut);
            IOUtils.closeQuietly(stdErr);
        }
        return ret;
    }

    private String processStream(InputStream inputStream, String charset) {
        byte[] buf = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while (inputStream.read(buf) != -1) {
                stringBuilder.append(new String(buf, charset));
            }
        } catch (Exception e) {
            logger.log(1, "数据流转换出现问题");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        RemoteShellExecutor remoteShellExecutor=new RemoteShellExecutor("10.159.191.107","haieradmin","qITH2*%C,6lFE7d");
        System.out.println(remoteShellExecutor.exec("/data/TRS/HtmToExcel/tmp/test.sh"));
    }
}
