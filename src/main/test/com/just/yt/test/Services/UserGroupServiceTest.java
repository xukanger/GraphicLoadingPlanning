package com.just.yt.test.Services;

import com.just.yt.project.entities.UserGroup;
import com.just.yt.project.services.UserGroupService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertNotNull;

/**
 * Created by yt on 2016/6/15.
 */
@Component
public class UserGroupServiceTest extends SpringTestBase{


    @Autowired
    UserGroupService userGroupService;


    @Test
    public void save() throws Exception {
        UserGroup userGroup=new UserGroup();
        userGroup.setName("管理员");
        userGroupService.save(userGroup);
    }

    @Test
    public void update() throws Exception {
        UserGroup userGroup=userGroupService.getObjectByName("测试");
        userGroup.setName("测试1");
    }

    @Test
    public void getObjectByName() throws Exception {
       assertNotNull(userGroupService.getObjectByName("管理员"));
    }


    @Test
    public void getObjectById() throws Exception{
        assertNotNull(userGroupService.getObjectById(2));
    }
}