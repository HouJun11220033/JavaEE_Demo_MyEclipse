package com.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import java.util.*;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;

	// username���Ե�setter��getter����
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	// password���Ե�setter��getter����
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public String execute() throws Exception {
		System.out.println("����execute����ִ����..........");
		if (getUsername().equals("root") && getPassword().equals("root")) {
			ActionContext ctx = ActionContext.getContext();
			Map session = ctx.getSession();
			session.put("user", getUsername());
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}