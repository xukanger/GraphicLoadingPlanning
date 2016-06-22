package com.just.yt.project.actions;


import com.just.yt.project.entities.MediaResource;
import com.just.yt.project.entities.Planning;
import com.just.yt.project.entities.User;
import com.just.yt.project.services.MediaResourceService;
import com.just.yt.project.services.PlanService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by yt on 2016/6/8.
 */
@Controller
@Namespace("/plan")
@ParentPackage("loginDefault")
public class PlanAction extends AbstractAction{
    @Resource
    PlanService planService;


    @Resource
    MediaResourceService mediaResourceService;

    String start_date;

    String end_date;

    String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMedia_name() {
        return media_name;
    }

    public void setMedia_name(String media_name) {
        this.media_name = media_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String media_name;

    String description;

    String title;

    int id;

    public MediaResourceService getMediaResourceService() {
        return mediaResourceService;
    }

    public void setMediaResourceService(MediaResourceService mediaResourceService) {
        this.mediaResourceService = mediaResourceService;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public PlanService getPlanService() {
        return planService;
    }

    public void setPlanService(PlanService planService) {
        this.planService = planService;
    }

    @Action(value = "list",results = {
            @Result(name = "success",location = "/plan/list")
    })
    public String list(){
        return super.list(Planning.class, planService);
    }

    @Action(value = "addorprofile",results = {
            @Result(name = "success",type = "redirect",location = "plan/list")
    })
    public String addorprofile(){
        Planning plan=new Planning();
        plan.setStart_time(parseDate(start_date));
        plan.setEnd_time(parseDate(end_date));
        plan.setTitle(title);
        plan.setDescription(description);
        plan.setUser((User) getSession().get("user"));
        planService.save(plan);

        return "success";
    }

    private Date parseDate(String date){
        if(date==null)return new Date();
        String[]dates=date.split("/");
        return new Date(Integer.parseInt(dates[2]),Integer.parseInt(dates[1]),Integer.parseInt(dates[0]));
    }

    @Action(value = "profile",results = {
            @Result(name = "success",type = "redirect",location = "plan/list")
    })
    public String profile(){
        MediaResource mediaResource=mediaResourceService.getObejectByName(media_name);
        Planning planning=planService.getObjectById(id);
        planning.setMediaResource(mediaResource);
        planService.update(planning);
        return "success";
    }
}
