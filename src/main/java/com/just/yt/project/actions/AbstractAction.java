package com.just.yt.project.actions;

import com.just.yt.project.services.AbstractService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by yt on 2016/6/6.
 */
@Controller
public class AbstractAction extends ActionSupport implements SessionAware,RequestAware{
    private Map<String, Object> request;

    public Map<String, Object> getRequest() {
        return request;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    private Map<String, Object> session;

    protected <T>String list(Class<T> clazz, AbstractService query){

        ArrayList<T> ArrayList = null;
        ArrayList = (java.util.ArrayList<T>) query.list();
        getSession().put("arraylist", ArrayList);
        return SUCCESS;
    }

}
