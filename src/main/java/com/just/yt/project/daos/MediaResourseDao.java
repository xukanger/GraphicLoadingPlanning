package com.just.yt.project.daos;

import cn.org.rapid_framework.page.Page;
import com.just.yt.project.entities.MediaResourse;

import javax.annotation.Resource;
import javax.print.attribute.standard.Media;
import java.util.List;

/**
 * Created by yt on 2016/6/6.
 */
public class MediaResourseDao extends AbstractDao{


    public List<MediaResourse> list(final String where) throws Exception {
        return (List<MediaResourse>) super.list("media_resourse",where);
    }

    public MediaResourse getObject(final String where){
        return (MediaResourse) super.getObject("media_resourse",where);
    }

    public List<MediaResourse> listByPage(final String where, Page<Object> page){
        return (List<MediaResourse>) super.listByPage("media_resourse",where,page);
    }

    public Long getCount(final String where){
        return super.getCount("media_resourse",where);
    }

}
