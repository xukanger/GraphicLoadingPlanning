package com.just.yt.project.services;

import com.just.yt.project.daos.MediaResourceDao;
import com.just.yt.project.entities.MediaResource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yt on 2016/6/8.
 */
@Service
public class MediaResourceService {
    @Resource
    MediaResourceDao mediaResourceDao;




    public MediaResourceDao save(MediaResource mediaResource){
        return (MediaResourceDao) mediaResourceDao.save(mediaResource);
    }


    public void update(MediaResource mediaResource){
        mediaResourceDao.update(mediaResource);
    }

    public MediaResource getMediaResourceById(int id){
        return mediaResourceDao.getObject("id="+id);
    }

    public List<MediaResource> list(){
        return new ArrayList<MediaResource>();
    }
}
