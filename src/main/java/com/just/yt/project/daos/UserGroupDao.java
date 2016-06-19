package com.just.yt.project.daos;

import cn.org.rapid_framework.page.Page;
import com.just.yt.project.entities.UserGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yt on 2016/6/6.
 */
@Repository
public class UserGroupDao extends AbstractDao{


    public List<UserGroup> list(final String where) throws Exception {
        return (List<UserGroup>) super.list("t_usergroup",where);
    }

    public UserGroup getObject(final String where){
        return (UserGroup) super.getObject("t_usergroup",where);
    }

    public List<UserGroup> listByPage(final String where, Page<Object> page){
        return (List<UserGroup>) super.listByPage("t_usergroup",where,page);
    }

    public Long getCount(final String where){
        return super.getCount("t_usergroup",where);
    }

}
