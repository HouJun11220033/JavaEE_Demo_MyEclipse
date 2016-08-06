package com.filter.filterTest;
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.filterTest;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
////@WebFilter(filterName = "authorityFilter", urlPatterns = {"/*"}, initParams = {
////    @WebInitParam(name = "encoding", value = "GBK"),
////    @WebInitParam(name = "loginPage", value = "/login.jsp"),
////    @WebInitParam(name = "proLogin", value = "/proLogin.jsp")
////}
////)
////@WebFilter(filterName="xxx",urlPatterns={"xxx"},initParams={@WebInitParam(name="xxx",value="xxx")})
//public class AuthorityFilter implements Filter {
//
//    private FilterConfig config;
//
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        this.config = config;
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String encoding = config.getInitParameter("encoding");
//        String loginPage = config.getInitParameter("loginPage");
//        String proLogin = config.getInitParameter("proLogin");
//        request.setCharacterEncoding(encoding);
//        HttpServletRequest requ = (HttpServletRequest) request;
//        HttpSession session = requ.getSession(true);
//        //获取客户的请求页面
//        String requestPath = requ.getServletPath();
//
//        if (session.getAttribute("user") == null && !requestPath.endsWith(loginPage) && !requestPath.endsWith(proLogin)) {
//            //forward
//            request.setAttribute("tip", "您还没有登陆");
//            request.getRequestDispatcher(loginPage).forward(request, response);
//
//        } else {
//            //放行
//            chain.doFilter(request, response);
//
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//        this.config = null;
//
//    }
//
// }
