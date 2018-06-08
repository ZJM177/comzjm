package myspring.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by zjm on 2018/6/1.
 */
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
//使用标准的JUnit @RunWith注释来告诉JUnit使用Spring TestRunner
@RunWith(SpringJUnit4ClassRunner.class)
public class EhCacheTestServiceTest {
    @Autowired
    private EhCacheTestService ehCacheTestService;
    @Test
    public void getTimestamp() throws Exception {

        System.out.println("第一次调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + ehCacheTestService.getTimestamp("param"));
    for (int j=0;j<2;j++){
        for (int i=1024;i>1;i--){
            //Thread.sleep(10);
            System.out.println("第"+i+"次调用：" + ehCacheTestService.getTimestamp("param"+i));
        }
    }
    }



    @Test
    public void getTimestamp2() throws Exception {

        for (int j=0;j<2;j++){
            for (int i=1024;i>1;i--){
                //Thread.sleep(10);
                System.out.println("第"+i+"次调用：" + ehCacheTestService.getTimestamp("param"+i));
            }
        }
    }

}