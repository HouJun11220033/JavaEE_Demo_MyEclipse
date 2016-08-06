package com.servlet;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

@WebServlet(loadOnStartup = 1)
public class TimerServlet extends HttpServlet {

	/**
	 * 
	 * @param config
	 * @throws ServletException
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		Timer t = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(new Date());
			}

		});
		t.start();

	}

}
