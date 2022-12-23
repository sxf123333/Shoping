package com.it.shop.service;

import com.it.shop.dao.UserDao;
import com.it.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-12-05 14:37:59
 */
@Service
public class UserService {
    @Resource
    UserDao userdao;
    //查询登陆
    public List<User> queryByPage(User user){
        return userdao.queryAllByLimit(user);
    };
    //注册添加
    public int insert(User user){
        return userdao.insert(user);
    };


    //充值购买
    public int update(User user){
        return userdao.update(user);
    }
    public int delete(User user){
        return userdao.deleteById(user.getId());
    }
    public User queryByPageId(User user){
        return userdao.queryById(user);
    };
}
