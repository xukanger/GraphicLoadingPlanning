package com.just.yt.project.services;

import cn.org.rapid_framework.page.Page;

import java.util.List;

/**
 * Created by yt on 2016/6/21.
 */
public abstract class AbstractService {
    public abstract  Long getCount();

    public abstract List queryByPage(String where, Page page);

    public abstract List list();
}
