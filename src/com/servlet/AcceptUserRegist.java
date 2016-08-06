// javaBean代码
package com.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class AcceptUserRegist extends HttpServlet {
	public String codeToString(String str) // 处理中文字符串的函数
	{
		String s = str;
		try {
			byte tempB[] = s.getBytes("ISO-8859-1");
			s = new String(tempB);
			return s;
		} catch (Exception e) {
			return s;
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置mime
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>接收新用户注册</title></head> <body>");
		out.println("这是新用户注册所提交的数据:<br>");
		out.println("用户名是:" + codeToString(request.getParameter("username"))
				+ "<br>");
		out.println("密码是:" + codeToString(request.getParameter("userpassword"))
				+ "<br>");
		out.println("性别是:" + codeToString(request.getParameter("sex")) + "<br>");
		out.println("出生年月是:" + request.getParameter("year")
				+ request.getParameter("month") + request.getParameter("day")
				+ "<br>");
		out.println("电子邮箱是:" + request.getParameter("E-mail") + "<br>");
		out.println("家庭住址是:" + codeToString(request.getParameter("address"))
				+ "<br>");
		out.print("</body> </html>");
	}

}