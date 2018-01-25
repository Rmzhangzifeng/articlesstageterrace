package org.maker.InterceptorConfig;

import org.maker.pojo.Users;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor implements HandlerInterceptor{


    /*在请求处理之前进行调用（Controller方法调用之前）*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        if(requestUri.equals("/loginCheck")){
            return true;
        }
        Users users = (Users)request.getSession().getAttribute("loginUserMsg");
        if (users == null || users.getUserid() == 0) {// 如果没有登录或登录超时
            response.sendRedirect(contextPath+"/login.jsp");
            return false;
        }
        return true;/*只有返回true才会继续向下执行，返回false取消当前请求*/
    }

    /*请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）*/
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
            /*适合做日志*/
    }

    /*在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）*/
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {

    }

}
