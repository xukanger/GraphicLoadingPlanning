package com.just.yt.project.actions;

import com.just.yt.project.daos.AbstractDao;
import com.just.yt.project.daos.UserDao;
import com.just.yt.project.entities.User;
import com.just.yt.project.services.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by yt on 2016/6/5.
 */
@Controller
@ParentPackage("loginDefault")
@Namespace("/user/login")
public class LoginAction extends AbstractAction{

    private User user;

    @Resource
    UserService userService;

    @Action(value = "login")
    public String login(){
        User checkedUser;
        if(user==null||((checkedUser=userService.loginIn(user))==null)) return "noLogin";
        else{
            getSession().put("user",checkedUser);
            return "success";
        }
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
