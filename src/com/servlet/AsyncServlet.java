//package com.servlet;
//import com.listenerTest.MyAsyncListener;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.AsyncContext;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(urlPatterns = {"/AsyncServlet"}, asyncSupported = true)
//public class AsyncServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setCharacterEncoding("text/html;charset=GBK");
//        PrintWriter out = response.getWriter();
//        out.println("<title>异步调用示例</title>");
//        out.println("进入Servlet的时间："
//                + new java.util.Date() + ".<br/>");
//        out.flush();
//        AsyncContext actx=request.startAsync();
//        actx.addListener(new MyAsyncListener());
//        actx.setTimeout(30*1000);
//        actx.start(new Executor(actx) {});
//        out.println("结束Servlet的时间：！！！！！！！！！！！！！" 
//			+ new java.util.Date() + ".<br/>");
//        out.flush();
//        
//        
//
//    }
//
// }
