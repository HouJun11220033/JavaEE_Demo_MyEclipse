///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.listenerTest;
//
//import com.servlet.DbDao;
//import java.sql.ResultSet;
//import javax.servlet.ServletRequestEvent;
//import javax.servlet.ServletRequestListener;
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@WebListener
//public class RequestListener implements ServletRequestListener {
//
//    @Override
//    public void requestInitialized(ServletRequestEvent sre) {
//        HttpServletRequest hsr = (HttpServletRequest) sre.getServletRequest();
//        //  System.out.println("Send to" + hsr.getRequestURI());
//        HttpSession session = hsr.getSession();//session需要用request
//        String sessionID = session.getId();
//        String ip = hsr.getRemoteAddr();
//        String page = hsr.getRequestURI();
//        String user = (String) session.getAttribute("user");
//
//        user = (user == null) ? "游客" : user;
//        try {
//            DbDao dd = new DbDao("com.mysql.jdbc.Driver",
//                    "jdbc:mysql://localhost:3306/online_inf",
//                    "root", "root"
//            );
//            ResultSet rs = dd.query("select * from online_inf where session_id=?", true, sessionID);
//            if (rs.next()) {
//                rs.updateString(4, page);
//                rs.updateLong(5, System.currentTimeMillis());
//                rs.updateRow();
//                rs.close();
//            } else {
//                dd.insert("insert into online_inf values(?,?,?,?,?)", sessionID, user, ip, page, System.currentTimeMillis());
//
//            }
//
//        } catch (Exception ex) {
//        }
//    }
//
//    @Override
//    public void requestDestroyed(ServletRequestEvent sre) {
//    }
//
//}
//
////
////    @Override
////    public void attributeAdded(ServletRequestAttributeEvent sre) {
////        HttpServletRequest hsr = (HttpServletRequest) sre.getServletRequest();
////        String name = sre.getName();
////        Object value = sre.getValue();
////        System.out.println(hsr+"范围内增加了:" + name + "值为:" + value);
////
////    }
////
////    @Override
////    public void attributeRemoved(ServletRequestAttributeEvent sre) {
////        HttpServletRequest hsr = (HttpServletRequest) sre.getServletRequest();
////        String name = sre.getName();
////        Object value = sre.getValue();
////        System.out.println(hsr+"范围内Delete了:" + name + "值为:" + value);
////
////    }
////
////    @Override
////    public void attributeReplaced(ServletRequestAttributeEvent sre) {
////        HttpServletRequest hsr = (HttpServletRequest) sre.getServletRequest();
////        String name = sre.getName();
////        Object value = sre.getValue();
////        System.out.println(hsr+"范围内Update了:" + name + "值为:" + value);
////
////    }
//
