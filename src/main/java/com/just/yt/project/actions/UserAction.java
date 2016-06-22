package com.just.yt.project.actions;


import com.just.yt.project.entities.MediaResource;
import com.just.yt.project.entities.User;
import com.just.yt.project.entities.UserGroup;
import com.just.yt.project.services.*;
import com.just.yt.project.services.ResParams.PercentCalculateData;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yt on 2016/6/5.
 */
@Controller
@ParentPackage("loginDefault")
@Namespace("/user")
public class UserAction extends AbstractAction{

    private User user;

    private String userGroupName;

    private static Logger logger= Logger.getLogger(UserAction.class);

    @Resource
    MediaResourceService mediaResourceService;

    @Resource
    UserService userService;

    @Resource
    UserGroupService userGroupService;

    @Resource
    PlanService planService;

    @Action(value = "login",results = {
            @Result(name = "success", location = "/index.jsp"),
    })

    public String login(){
        User checkedUser;
        if(user==null||((checkedUser=userService.loginIn(user))==null)) {
            logger.error("用户没有登录成功");
            return "noLogin";
        }
        else{
            logger.debug(checkedUser+"用户登录成功");
            getSession().put("user",checkedUser);
            putInformation(checkedUser);
            return "success";
        }
    }

    @Action(value="register",results = {
            @Result(name = "register", type = "redirect",location = "/user/register"),
            @Result(name = "success", location = "/index.jsp"),
    })
    public String register(){
        if(userGroupName==null||user==null||user.getAccount_name()==null||user.getPassword()==null){
            logger.error("用户没有登记成功");
            return "register";
        }
        else{
            UserGroup userGroup=userGroupService.getObjectByName(userGroupName);
            user.setUserGroup(userGroup);
            userService.save(user);
            logger.info(user+" "+userGroupName+" 用户注册成功");
            getSession().put("user",user);
            putInformation(user);
            return "success";
        }
    }

    @Action(value="list",results ={
            @Result(name = "success", type = "redirect",location = "/view/user/list.jsp"),
    })
    public String list(){

        return super.list(User.class, userService);
    }



    private void putInformation(User user){
        PercentCalculateData percentCalculateData=mediaResourceService.getPercent();

        if(user.getUserGroup().getName().equals("admin")){
            getSession().put("plansize",planService.getCount());
            getSession().put("usercount",userService.getCount());
        }

        if(user.getUserGroup().getName().equals("designer")){
            getSession().put("plansize",user.getPlanningArrayList().size());
        }

        getSession().put("mediacount",mediaResourceService.getCount());
        getSession().put("mediapercent",percentCalculateData);
        List<MediaResource> list=mediaResourceService.list();
        List<PercentCalculateData> temp=new ArrayList<>();
        for(MediaResource mediaResource:list){
            long remain=mediaResource.getRemain();
            long sum=mediaResource.getSum();
            PercentCalculateData percentCalculateData1=new PercentCalculateData(sum-remain,sum);
            percentCalculateData1.setName(mediaResource.getResource_name());
            temp.add(percentCalculateData1);
        }

        getSession().put("medialist",temp);

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
