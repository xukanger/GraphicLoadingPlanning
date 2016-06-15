package com.just.yt.project.services;

import com.just.yt.project.daos.PlanningDao;
import com.just.yt.project.entities.Planning;
import com.just.yt.project.untils.MyBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yt on 2016/6/8.
 */
@Service
public class PlanService {
    @Resource
    PlanningDao planningDao;

    public Integer save(Planning planning){
        return (Integer) planningDao.save(planning);
    }

    public Planning update(Planning newPlan){
        Planning old=getObjectById(newPlan.getId());
        MyBeanUtils.copyProperties(old,newPlan);
        planningDao.update(old);
        return old;
    }

    public void delete(Planning planning) {
        planningDao.delete(planning);
    }

    public Planning  getObjectById(Integer id){
        return planningDao.getObject("id="+id);
    }

}
