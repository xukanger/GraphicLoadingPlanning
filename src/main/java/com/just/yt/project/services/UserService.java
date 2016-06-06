package com.just.yt.project.services;

import com.just.yt.project.daos.UserDao;
import com.just.yt.project.entities.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yt on 2016/6/6.
 */
@Service
public class UserService {

    @Resource
    UserDao userDao;

    public User loginIn(User user){
        User checkedUser=userDao.getObject("account_name="+user.getAccount_name()+" AND "+"password="+user.getPassword());
        return checkedUser;
    }

    public void save(User user){
        userDao.save(user);
    }



}
