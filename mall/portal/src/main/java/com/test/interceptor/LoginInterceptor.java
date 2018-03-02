package com.test.interceptor;


import com.test.util.HttpUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{
    //是否停止请求
/*    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取所有cookie
        Cookie[] cookies = httpServletRequest.getCookies();
        for (Cookie c : cookies) {
            String token = c.getValue();
            //redis 中是否存在该token
            String data = HttpUtil.getData(("http://localhost:8083/tokenIsHad/" + token));
            if (data.equals("1")) {
                return true;

            }

        }

        httpServletResponse.sendRedirect("http://localhost:8083/toLogin");
        return true;
    }*/

    //是否停止请求
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取所有cookie
        Cookie[] cookies = httpServletRequest.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("isLogin")){
                String token = c.getValue();
                //redis中是否存在该token
                String data = HttpUtil.getData("http://localhost:8083/tokenIsHad/" + token);
                if (data.equals("1"))
                {
                    return  true;
                }

            }
        }
        //跳转到sso登录页面
        httpServletResponse.sendRedirect("http://localhost:8083/toLogin?returnurl=http://localhost:8082/cart/lookcart");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}






























