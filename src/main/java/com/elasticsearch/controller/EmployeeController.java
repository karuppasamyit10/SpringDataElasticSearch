/**
 * 
 */
package com.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elasticsearch.dao.EmployeeDao;
import com.elasticsearch.entity.Employee;

/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping("/index")
	public ModelAndView home(Model model) {
		try {
			model.addAttribute("employees", employeeDao.getEmployees());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/employee/add")
	public ModelAndView addEmployee(@ModelAttribute Employee employee) throws Exception {
		try {
			employeeDao.addEmployee(employee);
		} catch (Exception e) {
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/index");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/employee/delete")
	public ModelAndView deleteEmployee(int employeeId) throws Exception {
		try {
			employeeDao.deleteEmployee(employeeId);
		} catch (Exception e) {
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/index");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/employee/edit")
	public String editEmployee(Model model, int employeeId) throws Exception {
		Employee employeeObj = null;
		try {
			employeeObj = employeeDao.editEmployee(employeeId);
			model.addAttribute("employees", employeeDao.getEmployees());
			model.addAttribute("employee", employeeObj);
		} catch (Exception e) {
			return "error";
		}
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/employee/search")
	public String getEmployee(Model model, @RequestParam String search) {
		try {
			model.addAttribute("employees", employeeDao.getEmployee(search));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("employeeSearch", search);
		return "index";
	}
	
}
