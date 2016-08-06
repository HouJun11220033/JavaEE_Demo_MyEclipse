/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.sql.*;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "testServlet", urlPatterns = { "/testServlet" }, initParams = {
		@WebInitParam(name = "driver", value = "com.mysql.jdbc.Driver"),
		@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/cs"),
		@WebInitParam(name = "user", value = "root"),
		@WebInitParam(name = "pass", value = "root") })
public class TestServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		try {
			ServletConfig config = getServletConfig();
			String driver = config.getInitParameter("driver");
			String url = config.getInitParameter("url");
			String user = config.getInitParameter("user");
			String pass = config.getInitParameter("pass");
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			response.setContentType("text/html;charSet=gbk");
			PrintStream out = new PrintStream(response.getOutputStream());
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			out.println("<table bgcolor=\"#9999dd\" border=\"1\""
					+ "width=\"480\">");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getString(4) + "</td>");
				out.println("<td>" + rs.getString(6) + "</td>");
				out.println("</tr>");

			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

		} catch (ClassNotFoundException | SQLException ex) {
		}
		// Logger.getLogger(TestServlet.class.getName()).log(Level.SEVERE, null,
		// ex);

	}

}
