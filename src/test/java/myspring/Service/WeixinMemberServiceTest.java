package myspring.Service;

import myspring.AbstractSpringContextTest;
import myspring.mobel.WeixinMember;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by zjm on 2018/11/8.
 */
public class WeixinMemberServiceTest extends AbstractSpringContextTest {
    @Autowired
    WeixinMemberService weixinMemberService;
    @Test
    public void findById() throws Exception {
        WeixinMember weixinMember = weixinMemberService.findById(1);
        System.out.println(weixinMember);
    }

}