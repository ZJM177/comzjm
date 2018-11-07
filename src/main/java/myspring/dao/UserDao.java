package myspring.dao;/**
 * Created by zjm on 2018/11/7.
 */

import myspring.mobel.User;

/**
 * @author zhujiameng
 * @create 2018-11-07 14:38
 **/
public interface UserDao {
   User findById(int id);
}
