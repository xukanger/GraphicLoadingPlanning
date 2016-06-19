package com.just.yt.project.daos;

import cn.org.rapid_framework.page.Page;
import com.just.yt.project.entities.MediaResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yt on 2016/6/6.
 */
@Repository
public class MediaResourceDao extends AbstractDao{


    public List<MediaResource> list(final String where) {
        return (List<MediaResource>) super.list("t_media_resource",where);
    }

    public MediaResource getObject(final String where){
        return (MediaResource) super.getObject("t_media_rescource",where);
    }

    public List<MediaResource> listByPage(final String where, Page<Object> page){
        return (List<MediaResource>) super.listByPage("t_media_resource",where,page);
    }

    public Long getCount(final String where){
        return super.getCount("t_media_resource",where);
    }



    public MediaResource update(final MediaResource mediaResource){
        MediaResource newMediaResource=getObject("id="+mediaResource.getId());
        return newMediaResource;
    }



}
