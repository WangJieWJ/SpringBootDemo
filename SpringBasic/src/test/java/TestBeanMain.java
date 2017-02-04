import com.springBootTest.config.TestBeanConfig;
import com.springBootTest.test.TestBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Title: 使用Spring自带的测试功能进行测试 , 使用Java配置(在配置类中进行依赖注入)
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/8 0008.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
@ActiveProfiles("prod")
public class TestBeanMain {

    @Autowired
    private TestBean testBean;

    @Test
    public void prodBeanShouldInject(){
        String expected="from production profile";
        String actual=testBean.getContent();
        Assert.assertEquals(expected,actual);
    }

}
