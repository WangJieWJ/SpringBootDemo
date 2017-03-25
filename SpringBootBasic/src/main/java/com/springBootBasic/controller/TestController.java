package com.springBootBasic.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.springBootBasic.config.RabbitMQConfig;
import com.springBootBasic.constants.RabbitMQConstant;
import com.springBootBasic.pojo.AuthorSettings;
import com.springBootBasic.pojo.Student;
import com.springBootBasic.rabbitmqMessage.RabbitMQ_Send;
import com.springBootBasic.redisCache.RedisUtil;
import com.springBootBasic.service.TestService;
import com.springboot.common.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Title: 测试Controller
 * Description:
 *
 * @Api注解用来表述该服务的信息，如果不使用则显示类名称.
 * @ApiOperation注解用于表述接口信息
 * @ApiParam注解用于描述接口的参数 Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/9 0009.
 */
@Api(value = "测试Controller", description = "主要提供测试的Controller")
@RestController
public class TestController {

    private Logger logger = Logger.getLogger(TestController.class);

    // 常规属性的配置
    @Value("${create.author}")
    private String author;

    @ApiOperation(value = "读取配置文件中的数据")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getStr() {
        return "Hello World " + author;
    }

    // 类型安全的配置
    @Autowired
    private AuthorSettings authorSettings;

    @ApiOperation(value = "读取配置文件中的数据，使用持久化对象")
    @RequestMapping(value = "/index1", method = RequestMethod.POST)
    public String getStr1() {
        return "使用类型安全的配置：author name is " + authorSettings.getName() + " and author age is " + authorSettings.getAge();
    }

    @ApiOperation(value = "作为一个后台服务器")
    @RequestMapping(value = "/getData", method = RequestMethod.GET)
    public String getData() {
        Random random = new Random();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("time", new SimpleDateFormat("hh:mm:ss").format(new Date()));
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            if (random.nextBoolean()) {
                list.add(random.nextInt(100));
            } else {
                list.add(random.nextInt(100) * (-1));
            }
        }
        jsonObject.put("dataarray", list);
        return jsonObject.toString();
    }


    //规定请求的方式只能是POST请求
    //规定参数Username为必传参数(RequestParam)，id和age为可选
    @ApiOperation(value = "测试参数必传@RequestParam")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "用户ID", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "age", value = "用户年龄", dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(@RequestParam String Username, Long id, Integer age) {
        return Username + " POST方式登录成功！！！ id:" + id + " age" + age;
    }


    @ApiOperation(value = "在SpringBoot中获取Req和Res")
    @RequestMapping(value = "/getReqRes", method = RequestMethod.POST)
    public String getReq_Res() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("relativePath: " + request.getSession().getServletContext().getRealPath("/"));
        stringBuilder.append("contextPath: " + request.getSession().getServletContext().getContextPath());
        stringBuilder.append("serverInfo: " + request.getSession().getServletContext().getServerInfo());
        stringBuilder.append("<img src='/static/favicon.ico'/>");
        return stringBuilder.toString();
    }

    @ApiOperation(value = "文件上传")
    @ApiImplicitParam(name = "file", value = "上传的文件", required = true, dataType = "file", allowMultiple = true)
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String uploadFile(@RequestParam MultipartFile file) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        try {
            ServletInputStream in = request.getInputStream();
            String Str = StrUtil.inputStream2String(in, "UTF-8");
            System.out.println("InputStream: " + Str);

            //检查文件大小、文件上传类型
            //对于文件的保存以及下载问题的总结
            //要使用文件系统进行操作，使用绝对路径

//            response.sendRedirect("/SpringBoot/static/html/index.html");
        } catch (IOException e) {
            try {
                response.getWriter().print("文件上传出错，请稍后重试！");
            } catch (IOException io) {
            }
        }
        return file.getOriginalFilename();
    }

    @ApiOperation(value = "测试HTTP请求")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/http", method = RequestMethod.GET)
    public String testHttp(@RequestParam String userName, @RequestParam String passWord) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            ServletInputStream inputStream = request.getInputStream();
            String Str = StrUtil.inputStream2String(inputStream, "UTF-8");

            logger.info("InputStream: " + Str);


        } catch (IOException e) {
        }
        return "";
    }

    @ApiOperation(value = "测试文件传输")
    @RequestMapping(value = "/testFile", method = RequestMethod.GET)
    public void testFile() {
        File file0 = new File("G:/成绩单.png");
        File file1 = new File("G:/test.txt");
        File file2 = new File("G:/成绩单.png");
        File file3 = new File("G:/test.txt");

        List<File> files = new ArrayList<File>();
        files.add(file0);
        files.add(file1);
        files.add(file2);
        files.add(file3);

        try {
            files = (List<File>) deepClone(files);
        } catch (Exception e) {
            System.out.println("对象的深拷贝出现问题！");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("file", files);

        List<File> lists = (List<File>) map.get("file");
        try {
            for (File file : lists) {
                InputStream in = null;
                byte[] tempbytes = new byte[100];
                int byteread = 0;
                in = new FileInputStream(file);
                System.out.println("当前字节输入流中的字节数为:" + in.available());
                // 读入多个字节到字节数组中，byteread为一次读入的字节数
                while ((byteread = in.read(tempbytes)) != -1) {
                    System.out.write(tempbytes, 0, byteread);
                }
                System.out.println("---------------------------------");
            }
        } catch (IOException e) {
            System.out.println("出错");
        }

    }

    @ApiOperation(value = "测试请求的并发性")
    @ApiImplicitParam(name = "WxId", value = "微信ID", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public void test1(@RequestParam String WxId) {
        String Str = WxId + "---" + UUID.randomUUID().toString();
        System.out.println(Str);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            System.out.println("------------" + Str);
        }
        System.out.println("------------" + Str);
    }

    /**
     * 对象的深拷贝
     *
     * @return
     * @throws Exception
     */
    public static Object deepClone(Object object) throws Exception {
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(object);

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

    public static void main(String[] args) {

        String sresult = "http://www.haier.com/cn/consumer/cooling/dkmbx/201505/t20150519_269277.jpg";
//        http://test.haier.com/cn/xbsy_37860/interact_datas/201508/P020150818541296969073.jpg
        String[] extNames = new String[]{"jpg", "jpeg", "png", "gif"};
        //扩展名
        String extName = sresult.substring(sresult.lastIndexOf(".") + 1, sresult.length()).toLowerCase();
        if (sresult.startsWith("http://www.haier.com") && Arrays.asList(extNames).indexOf(extName) != -1) {
            sresult = sresult.replaceFirst("http://www.haier.com", "http://image.haier.com");
        }
        System.out.println(sresult);


        try {
            for (int i = 0; i < 20; i++) {
                System.out.println("index: " + i);
                if (i == 10) {
                    throw new IOException();
                }
            }
        } catch (IOException e) {
            System.out.println("baocuo ");
        }
        System.out.println("        }\n");
    }


}
