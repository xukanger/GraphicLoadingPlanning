package com.just.yt.project.daos;

import cn.org.rapid_framework.page.Page;
import com.just.yt.project.entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yt on 2016/6/5.
 */
@Repository
public class UserDao extends AbstractDao{


    public List<User> list(final String where) throws Exception {
        return (List<User>) super.list("user",where);
    }

    public User getObject(final String where){
        return (User) super.getObject("user",where);
    }

    public List<User> listByPage(final String where, Page<Object> page){
        return (List<User>) super.listByPage("user",where,page);
    }

    public Long getCount(final String where){
        return super.getCount("user",where);
    }


}
