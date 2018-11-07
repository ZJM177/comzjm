package myspring.Service.impl;

import myspring.Service.UserService;
import myspring.annotation.Test;
import myspring.dao.UserDao;
import myspring.mobel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现
 *
 * @author zhujiameng
 * @create 2018-06-01 11:32
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao  userDao;
    @Test(message = "12233")
    public int save(User user) {
        try{
            return 12;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Test
    private void create1() {
    }
}
