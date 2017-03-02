import com.springBootBasic.SpringBootApp;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/8 0008
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootApp.class)
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test(){
        //保存字符串
        stringRedisTemplate.opsForValue().set("aaa","HellowwWorldJava");
        Assert.assertEquals("HellowwWorldJava",stringRedisTemplate.opsForValue().get("aaa"));
        Assert.assertEquals(true,stringRedisTemplate.hasKey("aaa"));
    }

    @BeforeClass
    public static void testBeforeClass(){
        System.out.println("在所有测试方法前执行一次，一般在其中写上整体初始化的代码");
    }

    @AfterClass
    public static void testAfterClass(){
        System.out.println("在所有测试方法后执行一次，一般在其中写上销毁和释放资源的代码");
    }

    @Before
    public void testBefore(){
        System.out.println("在每个测试方法前执行，一般用来初始化方法（比如我们在测试别的方法时，类中与其他测试方法共享的值已经被改变，为了保证测试结果的有效性，我们会在@Before注解的方法中重置数据");
    }

    @After
    public void testAfter(){
        System.out.println("在每个测试方法后执行，在方法执行完成后要做的事情");
    }

    @Test(timeout = 100)
    public void testTimeOut(){
        System.out.println("测试方法执行超过1000毫秒后算超时，测试将失败");
    }

    @Test(expected = IOException.class)
    public void testException(){
        System.out.println("测试方法期望得到的异常类，如果方法执行没有抛出指定的异常，则测试失败");
    }


}
