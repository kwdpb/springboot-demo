package com.kw.Interceptor;

import com.kw.SpringbootWebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CommonInterceptor extends HandlerInterceptorAdapter {
    private static  final Logger logger= LoggerFactory.getLogger(CommonInterceptor.class);

//    业务处理器处理请求执行完成后，视图解析生成视图前
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("请求IP:"+request.getRemoteAddr());
        logger.info("请求的方法:"+request.getMethod());
        ModelMap modelMap=modelAndView.getModelMap();
        modelMap.addAttribute("title","主页");
    }
}
