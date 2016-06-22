package com.just.yt.project.actions;

import com.just.yt.project.entities.MediaResource;
import com.just.yt.project.services.MediaResourceService;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
@Namespace("/resource")
@ParentPackage("loginDefault")
public class ResourceAction extends AbstractAction{

    Logger logger= Logger.getLogger(ResourceAction.class);


    @Resource
    MediaResourceService mediaResourceService;


    @Action(value="list",results ={
            @Result(name = "success", type = "redirect",location = "/view/resource/list.jsp"),
    })
    public String list(){
        return super.list(MediaResource.class, mediaResourceService);
    }



    public MediaResourceService getMediaResourceService() {
        return mediaResourceService;
    }

    public void setMediaResourceService(MediaResourceService mediaResourceService) {
        this.mediaResourceService = mediaResourceService;
    }

}

