import com.springBootBasic.SpringBootApp;
import com.springBootBasic.dao.repository.UserRepository;
import com.springBootBasic.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
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

    /**
     * 测试分页 对于同一个表的查询语句
     */
    @Test
    public void testPage(){
        List<Sort.Order> list=new ArrayList<Sort.Order>();
        //先按照password来进行降序排序
        Sort.Order orderByPassWord=new Sort.Order(Sort.Direction.DESC,"passWord");
        //再按照id来进行升序排序
        Sort.Order orderByUserName=new Sort.Order(Sort.Direction.ASC,"id");
        list.add(orderByPassWord);
        list.add(orderByUserName);

        Sort sort=new Sort(list);
        Pageable pageable=new PageRequest(1,20,sort);
        Page<User> page=userRepository.findAll(pageable);
        System.out.println("总记录数："+page.getTotalElements());
        System.out.println("总页数："+page.getTotalPages());
        System.out.println("查询到的数据："+page.getSize());
        for(User user:page){
            System.out.println("ID:"+user.getId()+" name:"+user.getName()+" passWord:"+user.getPassWord());
        }
    }

}
