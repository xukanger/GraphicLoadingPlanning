package com.just.yt.test.Services;

import com.just.yt.project.entities.Planning;
import com.just.yt.project.entities.User;
import com.just.yt.project.services.PlanService;
import com.just.yt.project.services.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by yt on 2016/6/15.
 */
@Service
public class PlanServiceTest extends SpringTestBase{

    static Logger logger=Logger.getLogger(PlanServiceTest.class);

    @Resource
    PlanService planService;

    @Resource
    UserService userService;

    @Test
    public void save() throws Exception {
        Planning planning=new Planning();
        planning.setDescription("测试文本");
        planning.setStart_time(new Date());
        planning.setEnd_time(new Date());
        User user=userService.getObjectById(1);
        planning.setUser(user);
        planService.save(planning);
        logger.error(user.getPlanningArrayList().toString());
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getObjectById() throws Exception {

    }
}