package myspring.dao;/**
 * Created by zjm on 2018/11/8.
 */

import myspring.mobel.WeixinMember;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhujiameng
 * @create 2018-11-08 14:11
 **/
public interface WeixinMemberDao {
    WeixinMember findById(@Param("id") int id);
}
