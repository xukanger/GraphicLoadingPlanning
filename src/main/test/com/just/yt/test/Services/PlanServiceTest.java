package com.just.yt.test.Services;

import com.just.yt.project.services.PlanService;
import com.just.yt.project.services.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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