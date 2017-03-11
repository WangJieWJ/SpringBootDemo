import com.springBootBasic.SpringBootApp;
import com.springBootBasic.dao.repository.UserRepository;
import com.springBootBasic.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootApp.class)
@WebAppConfiguration
public class JPARepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        userRepository.save(new User("WangJie",24));
        userRepository.save(new User("WangJie",24));
        userRepository.save(new User("WangJie",24));
        userRepository.save(new User("WangJie",24));

        List<User> list=userRepository.findAll();
        for(User user: list){
            System.out.println("ID: "+user.getId()+" NAME:"+user.getName()+" AGE:"+user.getPassWord());
        }
    }

}
