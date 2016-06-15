package com.just.yt.project.untils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by yt on 2016/6/15.
 */
@Component
public class MyBeanUtils {
    public static void copyProperties(Object target,Object source,String...properties){
        BeanUtils.copyProperties(target, source, properties);
    }
}
