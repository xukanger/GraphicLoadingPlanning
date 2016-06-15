package com.just.yt.project.actions;

import com.just.yt.project.entities.MediaResource;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.annotation.Resource;

/**
 * Created by yt on 2016/6/8.
 */
@ParentPackage("userDefault")
public class ResourceAction extends AbstractAction{

    Logger logger=Logger.getLogger(ResourceAction.class);

    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Resource
    MediaResource mediaResource;

    public MediaResource getMediaResource() {
        return mediaResource;
    }

    public void setMediaResource(MediaResource mediaResource) {
        this.mediaResource = mediaResource;
    }

    @Action(value = "add",results = {
            @Result(name = "success",location = "jsp/"),
    })
    String add(){

        return "success";
    }

    @Action(value = "index",results = {
            @Result(name = "success",location = "jsp/"),
            @Result(name = "index",location ="jsp/")
    })
    String index(){
        return "success";
    }

    @Action(value = "profile",results = {
            @Result(name = "success",location = "jsp"),
            @Result(name = "index",location="jsp"),
            @Result(name = "profile",location = "jsp/")
    })
    String profile(){
        return "success";
    }
}
