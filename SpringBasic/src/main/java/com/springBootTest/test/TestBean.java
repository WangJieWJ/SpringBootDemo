package com.springBootTest.test;

/**
 * Title: 使用Spring自带的测试功能进行测试 , 使用Java配置(在配置类中进行依赖注入)
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/8 0008.
 */
public class TestBean {
    private String content;

    public TestBean(String content){
        super();
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
