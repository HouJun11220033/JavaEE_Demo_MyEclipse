package com.spring.guigu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.guigu.dao.EmployeeDao;
import com.spring.guigu.exception.UserNameNotMatchPasswordException;
import com.spring.guigu.model.Employee;

@Controller
// @RequestMapping("springmvc")
public class Controller_2 {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private ResourceBundleMessageSource messageSource;

	@RequestMapping(value = "/testDefaultHandlerExceptionResolver", method = RequestMethod.POST)
	public String testDefaultHandlerExceptionResolver() {
		System.out.println("testDefaultHandlerExceptionResolver...");

		return "success";
	}

	@ResponseStatus(reason = "测试", value = HttpStatus.NOT_FOUND)
	@RequestMapping("/testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam("i") int i) {
		if (i == 13) {
			throw new UserNameNotMatchPasswordException();
		}
		System.out.println("testResponseStatusExceptionResolver...");

		return "success";
	}

	@RequestMapping("/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam("i") int i) {
		String[] vals = new String[10];
		System.out.println(vals[i]);
		return "success";

	}

	// @ExceptionHandler({ ArithmeticException.class })
	// public ModelAndView handleArithmeticException(Exception ex) {
	// System.out.println("出异常了: " + ex);
	// ModelAndView mv = new ModelAndView("error");
	// mv.addObject("exception", ex);
	// return mv;
	// }

	@RequestMapping("/testExceptionHandlerExceptionResolver")
	public String testExceptionHandlerExceptionResolver(@RequestParam("i") int i) {
		System.out.println("result: " + (10 / i));

		return "success";
	}

	@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session)
			throws IOException {
		byte[] body = null;
		ServletContext servletContext = session.getServletContext();
		InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
		body = new byte[in.available()];
		in.read(body);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");

		HttpStatus statusCode = HttpStatus.OK;

		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body,
				headers, statusCode);
		return response;
	}

	@ResponseBody
	@RequestMapping("/testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body) {
		System.out.println(body);
		return "HelloWorld !" + new Date();
	}

	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson() {
		return employeeDao.getAll();

		// return "index";
	}

	@RequestMapping("/testConversionServiceConverer")
	public String testConverter(@RequestParam Employee employee) {
		System.out.println("Save:" + employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}

}
