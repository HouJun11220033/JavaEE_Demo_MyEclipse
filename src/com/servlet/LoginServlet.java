///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.servlet;
//
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author Sammy Guergachi <sguergachi at gmail.com>
// */
//@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
//public class LoginServlet extends HttpServlet {
//
//    @Override
//    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String errMsg = "";
//        RequestDispatcher rd;
//        String username = request.getParameter("username");
//        String pass = request.getParameter("pass");
//        try {
//
//            DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/cs", "root", "root");
//            ResultSet rs = dd.query("select pass from user_table" + "where name=?", username);
//            if (rs.next()) {
//                if (rs.getString("pass").equals(pass)) {
//                    //获取session对象
//                    HttpSession session = request.getSession(true);
//                    //设置session属性
//                    session.setAttribute("name", username);
//                    rd = request.getRequestDispatcher("/welcome.jsp");
//                    rd.forward(request, response);
//
//                } else {
//                    errMsg += "Your username or password is not correct!";
//                }
//            } else {
//                errMsg += "Your username not exists!";
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (errMsg != null && !errMsg.equals("")) {
//            rd = request.getRequestDispatcher("/login.jsp");
//            request.setAttribute("err", errMsg);
//            rd.forward(request, response);
//        }
//
//    }
//
// }
