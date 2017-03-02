package com.springBootBasic.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @ApiOperation(value = "asdad")
    @RequestMapping(value = "/demo",method = RequestMethod.POST)
    public void post_JSON(){
//        HttpPost post=new HttpPost("");

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

    public static void main(String[] args) {
        String Str="http://test.haier.com/wechat/gh_d75afe1c0b21/wyy/201611/P020161108565326786139.jpg";
        int start=Str.lastIndexOf("/");
        System.out.println(Str.substring(start+1));


        String UUID= java.util.UUID.randomUUID().toString();
        System.out.println(UUID);
    }

}
