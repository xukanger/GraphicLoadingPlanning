package com.just.yt.project.services;

import cn.org.rapid_framework.page.Page;
import com.just.yt.project.daos.PlanningDao;
import com.just.yt.project.entities.Planning;
import com.just.yt.project.untils.MyBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yt on 2016/6/8.
 */
@Service
public class PlanService extends AbstractService{

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


    public Long getCount(){
        return planningDao.getCount("");
    }

    @Override
    public List queryByPage(String where, Page page) {
        return planningDao.listByPage(where,page);
    }

    @Override
    public List list() {
        return planningDao.list("");
    }

}
