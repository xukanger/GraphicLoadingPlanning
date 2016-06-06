package com.just.yt.project.interceptors;

import com.just.yt.project.entities.User;
import com.just.yt.project.entities.UserGroup;
import com.just.yt.project.untils.Constant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by yt on 2016/6/5.
 */
public class UserCheckInterceptor extends AbstractInterceptor {


    static Logger logger=Logger.getLogger(UserCheckInterceptor.class);

    public String intercept(ActionInvocation actionInvocation) throws Exception {


        ActionProxy actionProxy = actionInvocation.getProxy();
        String method = actionProxy.getMethod();
        String namespace = actionProxy.getNamespace();
        String action = namespace.substring(namespace.lastIndexOf("/")+1, namespace.length());

        ActionContext actionContext = actionInvocation.getInvocationContext();
        Map<?,?> sessionMap= actionInvocation.getInvocationContext().getSession();
        User user= (User) sessionMap.get("user");
        if(user==null){
            logger.info("没有登录");
            return "noLogin";
        }

        else{
            UserGroup userGroup=user.getUserGroup();
            logger.info("已经验证权限");
            //TODO
            return actionInvocation.invoke();
        }


    }
}
