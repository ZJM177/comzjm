package myspring.Service;

import myspring.mobel.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by zjm on 2018/11/2.
 */
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void save() throws Exception {
        User user = new User(1, "2");
        userService.save(user);
    }

    @Test
    public void find() throws Exception {
    System.out.println(userService.findById(1));
    }

}