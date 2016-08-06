package com.spring.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("root")
public class HelloWorldController {
	@RequestMapping(value = "helloworld", method = RequestMethod.GET, params = {
			"username=10", "age!=20" })
	public String hello() {
		System.out.println("Hello World ! ! !");

		return "success";
	}

}
