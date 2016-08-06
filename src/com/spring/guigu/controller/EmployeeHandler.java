package com.spring.guigu.controller;

import com.spring.guigu.dao.DepartmentDao;
import com.spring.guigu.dao.EmployeeDao;
import com.spring.guigu.model.Employee;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	@ModelAttribute
	public void getEmployee(
			@RequestParam(value = "id", required = false) Integer id,
			Map<String, Object> map) {
		if (id != null) {
			map.put("employee", employeeDao.get(id));
		}
	}

	// 怎样才能实现编辑时候也能进行验证？？？
	@RequestMapping(value = "/emp{id}", method = RequestMethod.POST)
	public String update(@PathVariable("id") Integer id,
			@Valid Employee employee, BindingResult result,
			Map<String, Object> map) {
		if (result.getErrorCount() > 0) {
			System.out.println("编辑个人信息出错 !");
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":"
						+ error.getDefaultMessage());
			}
			map.put("employee", employeeDao.get(id));
			map.put("departments", departmentDao.getDepartments());
			// return "redirect:/emp";
			return "input";

		}

		employeeDao.save(employee);
		return "redirect:/emps";
	}

	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String save(@Valid Employee employee, BindingResult result,
			Map<String, Object> map) {
		System.out.println("save:" + employee);
		if (result.getErrorCount() > 0) {
			System.out.println("Error ! ! !");
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":"
						+ error.getDefaultMessage());
			}
			map.put("departments", departmentDao.getDepartments());
			// 这个可以表单回显
			return "input";

		}

		employeeDao.save(employee);
		return "redirect:/emps";

	}

	// 表单回显
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	public String dataReturn(@PathVariable("id") Integer id,
			Map<String, Object> map) {
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}

	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}

	// 转到input页面,并且给他准备好Map集合，以便输入时好相互对应
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String getInputPage(Map<String, Object> map) {
		map.put("departments", departmentDao.getDepartments());
		// 往里面放employee时候，构造函数里面什么都没有
		map.put("employee", new Employee());
		return "input";

	}

	@RequestMapping("/emps")
	public String list(Map<String, Object> map) {
		map.put("employees", employeeDao.getAll());
		return "list";
	}

}
