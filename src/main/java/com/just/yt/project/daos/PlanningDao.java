package com.just.yt.project.daos;

import cn.org.rapid_framework.page.Page;
import com.just.yt.project.entities.Planning;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yt on 2016/6/6.
 */
@Repository
public class PlanningDao extends AbstractDao{


    public List<Planning> list(final String where) {
        return (List<Planning>) super.list("t_plan",where);
    }

    public Planning getObject(final String where){
        return (Planning) super.getObject("t_plan",where);
    }

    public List<Planning> listByPage(final String where, Page<Object> page){
        return (List<Planning>) super.listByPage("t_plan",where,page);
    }

    public Long getCount(final String where){
        return super.getCount("t_plan",where);
    }

}
