package myspring.Service.impl;

import myspring.Service.WeixinMemberService;
import myspring.dao.WeixinMemberDao;
import myspring.mobel.WeixinMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhujiameng
 * @create 2018-11-08 14:20
 **/
@Service
public class WeixinMemberServiceImpl implements WeixinMemberService {
    @Autowired
    WeixinMemberDao  weixinMemberDao;
    @Override
    public WeixinMember findById(int id) {
        return weixinMemberDao.findById(id);
    }
}
