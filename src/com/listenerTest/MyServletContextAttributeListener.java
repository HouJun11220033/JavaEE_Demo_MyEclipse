///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.listenerTest;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextAttributeEvent;
//import javax.servlet.ServletContextAttributeListener;
//import javax.servlet.annotation.WebListener;
//@WebListener
//public class MyServletContextAttributeListener implements ServletContextAttributeListener {
//
//    @Override
//    public void attributeAdded(ServletContextAttributeEvent event) {
//        //这玩意儿好像没啥用啊???
//        ServletContext application=event.getServletContext();
//        String name = event.getName();
//        Object value = event.getValue();
//        System.out.println("范围内增加了:" + name + "值为:" + value);
//
//    }
//
//    @Override
//    public void attributeRemoved(ServletContextAttributeEvent event) {
//        String name = event.getName();
//        Object value = event.getValue();
//        System.out.println("范围内删除了了:" + name + "值为:" + value);
//
//    }
//
//    @Override
//    public void attributeReplaced(ServletContextAttributeEvent event) {
//        String name = event.getName();
//        Object value = event.getValue();
//        System.out.println("范围内修改了:" + name + "值为:" + value);
//
//    }
//
// }
