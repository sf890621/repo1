package com.itheima.web.interceptor;

import com.itheima.domain.Userlogin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Userlogin userlogin = (Userlogin) request.getSession().getAttribute("logined");
        if (userlogin == null){
            request.getSession().setAttribute("errorMsg","您尚未登录,请先登录...");
            request.getRequestDispatcher(request.getContextPath()+"/login.jsp").forward(request,response);
            return false;
        } else {
            return true;
        }
    }
}
