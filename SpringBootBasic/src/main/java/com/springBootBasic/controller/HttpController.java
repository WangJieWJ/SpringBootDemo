package com.springBootBasic.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:
 * Description: 测试多种HTTP请求的发起与接收
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/20 0020
 */
@Api(value = "HTTP Demo", description = "主要用来测试文件HTTP请求")
@RestController
public class HttpController {

    /**
     * 文件上传
     */
    public void post_JSON(){
        HttpPost post=new HttpPost("");

//        JSONObject response=null;
//        JSONObject params=new JSONObject();
//        JSONObject filter=new JSONObject();
//        filter.put("group_id",0);
//        params.put("filter",filter);
//        params.put("type","mpnews");
//        StringEntity entity=new StringEntity(params.toString());
//        entity.setContentEncoding("UTF-8");
//        entity.setContentType("application/json");
//        post.setEntity(entity);
//
//        DefaultHttpClient client=new DefaultHttpClient();
//        HttpResponse res=client.execute(post);
//        if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//            String result= EntityUtils.toString(res.getEntity());//返回JSON数据
//            response=JSONObject.fromObject(result);
//        }


    }


}
