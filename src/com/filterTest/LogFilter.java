//package com.filterTest;
//
//import java.io.IOException;
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//
///**
// *
// * @author Houjun
// */
////urlPatterns={"/*"}会截获所有jsp文件
////@WebFilter(filterName = "log", urlPatterns = {"/*"})
//
//public class LogFilter implements Filter {
//
//    private FilterConfig config;//可以获取在web.xml中的参数，是获取！！！
//    @Override
//    public void init(FilterConfig config)
//    {
//        this.config=config;//初始化时会用到config这个对象！！！
//    }
//    public void destory()
//    {
//          this.config=null;//销毁时，将config内容置为空
//    }
//    @Override
//    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException//HttpServletRequest、 HttpServletResponse分别是ServletRequest和ServletResponse的子类
//            //HttpServletRequest比ServletRequest多了一些针对于Http协议的方法
//    {
//        //servletContext接口是Servlet中最大的一个接口，呈现了web应用的Servlet视图。ServletContext实例是通过getServletContext()方法获得的
//        //ServletContext对象是在Web应用程序装载时初始化的
//        //<context-param>元素是针对整个应用的，所以并不嵌套在某个<servlet>元素中，该元素是<web-app>元 素的直接子元素
//        ServletContext context=this.config.getServletContext();
//        long before=System.currentTimeMillis();
//        System.out.println("开始过滤...");
//        HttpServletRequest hrequest=(HttpServletRequest) request;
//        System.out.println("已经截获地址"+hrequest.getServletPath());
//        chain.doFilter(request,response);
//        long after=System.currentTimeMillis();
//        System.out.println("End!!!");
//        System.out.println("已经定位到"+hrequest.getRequestURL()+"所花时间"+(after-before));
//    }
//
//    @Override
//    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); 
//    }
//    
//
//
// }
