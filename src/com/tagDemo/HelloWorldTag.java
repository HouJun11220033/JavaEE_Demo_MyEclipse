package com.tagDemo;

import java.io.IOException;

import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.struts2.components.Date;

public class HelloWorldTag extends SimpleTagSupport {
	@Override
	public void doTag() throws IOException {
		getJspContext().getOut().write("HelloWorld!!!" + new Date(null));
	}

}