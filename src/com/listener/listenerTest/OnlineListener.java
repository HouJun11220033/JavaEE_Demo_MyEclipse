package com.listener.listenerTest;
//package com.listenerTest;
//
//import com.servlet.DbDao;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//@WebListener
//public class OnlineListener implements ServletContextListener {
//
//    public final int MAX_MILLIS = 10 * 60 * 1000;
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        new javax.swing.Timer(1000 * 5, new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    DbDao dd = new DbDao("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/online_inf", "root", "32147");
//
//                    ResultSet rs = dd.query("select * from online_inf", false);
//                    StringBuffer beRemove = new StringBuffer("(");
//                    while (rs.next()) {
//                        if ((System.currentTimeMillis() - rs.getLong(5))
//                                > MAX_MILLIS) {
//
//                            beRemove.append("'");
//                            beRemove.append(rs.getString(1));
//                            beRemove.append("' , ");
//                        }
//                    }
//                    if (beRemove.length() > 3) {
//                        beRemove.setLength(beRemove.length() - 3);
//                        beRemove.append(")");
//
//                        dd.modify("delete from online_inf where session_id in "
//                                + beRemove.toString());
//                    }
//                    dd.closeConn();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//
//                }
//            }
//
//        }).start();
//
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//
//    }
//
////    public void sessionCreated(HttpSessionEvent se) {
////        HttpSession session = se.getSession();
////        ServletContext application = session.getServletContext();
////        String sessionID = session.getId();
////        String user = (String) session.getAttribute("user");
////
////        if (session.isNew()) {
////            user=(user==null)?"游客":user;
////            Map<String, String> online = (Map<String, String>) application.getAttribute("online");
////           if (online == null) {
////                   online = new Hashtable<String,String>();
////            }
////            online.put(sessionID, user);
////
////            //online是一个全局的集合,每一个session来自一个用户,所以用户信息用session获取，最终放在全局集合里面
////            application.setAttribute("online", online);
////
////        }
////
////    }
////
////    @Override
////    //会话结束时，消除该用户的信息
////    public void sessionDestroyed(HttpSessionEvent se) {
////        HttpSession session = se.getSession();
////        ServletContext application = session.getServletContext();
////        String sessionID = session.getId();
////        Map<String, String> online = (Map<String, String>) application.getAttribute("online");
////        if (online != null) {
////            online.remove(sessionID);
////        }
////        //这个应该是对全局集合online操作完毕后，更新的操作？？？？
////        application.setAttribute("online", online);
////
////    }
// }
