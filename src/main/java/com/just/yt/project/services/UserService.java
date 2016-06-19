package com.just.yt.project.services;

import com.just.yt.project.daos.UserDao;
import com.just.yt.project.entities.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Created by yt on 2016/6/6.
 */
@Service
public class UserService {

    @Resource
    UserDao userDao;

    public User loginIn(User user){
        return userDao.getObject("account_name='"+user.getAccount_name()+
                "' AND "+"password='"+user.getPassword()+"'");
    }


    public Integer save(User user){
        return (Integer) userDao.save(user);
    }

    public Boolean checkUserExistByName(final String name){
        return !Objects.isNull(userDao.getObject("account_name='"+name+"'"));
    }

    public User getObjectById(Integer id){
        return userDao.getObject("id="+id);
    }


    public Long getCount(){
        return userDao.getCount("");
    }


}
