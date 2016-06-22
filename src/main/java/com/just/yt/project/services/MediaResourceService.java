package com.just.yt.project.services;

import cn.org.rapid_framework.page.Page;
import com.just.yt.project.daos.MediaResourceDao;
import com.just.yt.project.entities.MediaResource;
import com.just.yt.project.services.ResParams.PercentCalculateData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yt on 2016/6/8.
 */
@Service
public class MediaResourceService extends AbstractService{
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
        return mediaResourceDao.list("");
    }

    public MediaResource getObejectByName(String name){
        return mediaResourceDao.getObject("name='"+name+"'");
    }
    public Long getCount(){
        return mediaResourceDao.getCount("");
    }

    @Override
    public List queryByPage(String where, Page page) {
        return mediaResourceDao.listByPage(where,page);
    }

    public PercentCalculateData getPercent(){
        List<MediaResource> list=mediaResourceDao.list("");
        long sum=0,remain=0;
        for(MediaResource temp:list){
            sum+=temp.getSum();
            remain+=temp.getRemain();
        }

        return new PercentCalculateData(sum-remain,sum);
    }

    public List<PercentCalculateData> getPercents(){
        List<PercentCalculateData> list=new ArrayList<>();
        List<MediaResource> mediaResources=mediaResourceDao.list("");
        for(MediaResource mediaResource :mediaResources){
            long remain=mediaResource.getRemain();
            long sum=mediaResource.getSum();
            list.add(new PercentCalculateData(sum-remain,sum));
        }
        return list;
    }

}
