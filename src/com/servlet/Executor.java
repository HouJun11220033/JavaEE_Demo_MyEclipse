package com.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;

public class Executor implements Runnable {

	private AsyncContext actx = null;

	public Executor(AsyncContext actx) {
		this.actx = actx;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5 * 1000);
			ServletRequest request = actx.getRequest();
			List<String> books = new ArrayList<String>();
			books.add("疯狂Java讲义");
			books.add("经典Java EE企业应用实战");
			books.add("疯狂XML讲义");
			request.setAttribute("books", books);
			actx.dispatch("/async.jsp");
		} catch (InterruptedException ex) {
			Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null,
					ex);
		}

	}

}
