package com.just.yt.project.actions;


import com.just.yt.project.entities.User;
import com.just.yt.project.entities.UserGroup;
import com.just.yt.project.services.UserGroupService;
import com.just.yt.project.services.UserService;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by yt on 2016/6/5.
 */
@Controller
@ParentPackage("loginDefault")
@Namespace("/user/login")
public class UserAction extends AbstractAction{

    private User user;

    private String userGroupName;

    private static Logger logger= Logger.getLogger(UserAction.class);

    @Resource
    UserService userService;

    @Resource
    UserGroupService userGroupService;


    @Action(value = "login")
    public String login(){
        User checkedUser;
        if(user==null||((checkedUser=userService.loginIn(user))==null)) {
            logger.error("用户没有登录成功");
            return "noLogin";
        }
        else{
            logger.info(checkedUser+"用户登录成功");
            getSession().put("user",checkedUser);
            return "success";
        }
    }

    @Action(value="register",results = {
            @Result(name = "register", location = "jsp/register.jsp"),
    })
    public String register(){
        if(userGroupName==null||user==null||user.getAccount_name()==null||user.getPassword()==null){
            logger.error("用户没有登记成功");
            return "register";
        }
        else{
            UserGroup userGroup=userGroupService.getObjectByName(userGroupName);
            user.setUserGroup(userGroup);
            logger.info(user+" "+userGroupName+" 用户注册成功");
            userService.save(user);
            return "noLogin";
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

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public UserGroupService getUserGroupService() {
        return userGroupService;
    }

    public void setUserGroupService(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

}
