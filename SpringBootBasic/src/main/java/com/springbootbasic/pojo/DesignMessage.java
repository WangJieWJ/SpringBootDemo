package com.springbootbasic.pojo;

import java.util.Date;
import java.util.Map;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/10 0010
 */
public class DesignMessage {

    private String id;                    //消息的ID
    private String fromName;           //消息的来源
    private String toName;             //消息的去处
    private Map<String,Object> data;   //消息的数据
    private Date time;                 //消息发送的时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public DesignMessage(String messageId,String fromName,String toName,Map<String,Object> map){
        this.id=messageId;
        this.fromName=fromName;
        this.toName=toName;
        this.time=new Date();
        this.data=map;
    }
}
