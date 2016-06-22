package com.just.yt.test.Services;

import com.just.yt.project.entities.User;
import com.just.yt.project.services.UserGroupService;
import com.just.yt.project.services.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yt on 2016/6/15.
 */
@Service
public class UserServiceTest extends SpringTestBase{

    @Autowired
    UserService userService;

    @Autowired
    UserGroupService userGroupService;

    @Test
    public void save() throws Exception{
        User user=new User();
        user.setUserGroup(userGroupService.getObjectByName("管理员"));
        user.setAccount_name("宋力力");
        user.setPassword("123456");
        userService.save(user);
    }

    @Test
    public void loginIn() throws Exception {
//        User user=new User();
//        user.setAccount_name("宋力力");
//        user.setPassword("123456");
//        assertNotNull(userService.loginIn(user));
    }




    @Test
    public void checkUserExistByName() throws Exception {
//        assertTrue(userService.checkUserExistByName("宋力力"));
    }

    @Test
    public void getObjectById() throws Exception{
        //assertNotNull(userService.getObjectById(1));
    }
}