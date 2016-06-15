package com.just.yt.project.services;

import com.just.yt.project.daos.UserGroupDao;
import com.just.yt.project.entities.UserGroup;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yt on 2016/6/8.
 */
@Service
public class UserGroupService {

    @Resource
    UserGroupDao userGroupDao;

    public Integer save(UserGroup userGroup){
        return (Integer) userGroupDao.save(userGroup);
    }

    public void update(UserGroup userGroup){


        userGroupDao.update(userGroup);
    }


    public UserGroup getObjectByName(String name){
        return userGroupDao.getObject("name='"+name+"'");
    }

    public UserGroup getObjectById(Integer id){
        return userGroupDao.getObject("id="+id);
    }
}
