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

import com.elasticsearch.dao.EmployeeJpaDao;
import com.elasticsearch.jpa.entity.EmployeeJpa;

/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */
@Controller
public class EmployeeJpaController {
	
	@Autowired
	private EmployeeJpaDao employeeJpaDao;
	
	@RequestMapping("/jpaIndex")
	public ModelAndView jpaHome(Model model) {
		try {
			model.addAttribute("employees", employeeJpaDao.getEmployees());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("jpaIndex");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/jpa/employee/add")
	public ModelAndView addJpaEmployee(@ModelAttribute EmployeeJpa employee) throws Exception {
		try {
			employeeJpaDao.addEmployee(employee);
		} catch (Exception e) {
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/jpaIndex");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/jpa/employee/delete")
	public ModelAndView deleteJpaEmployee(int employeeId) throws Exception {
		try {
			employeeJpaDao.deleteEmployee(employeeId);
		} catch (Exception e) {
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/jpaIndex");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/jpa/employee/edit")
	public String editJpaEmployee(Model model, int employeeId) throws Exception {
		EmployeeJpa employeeObj = null;
		try {
			employeeObj = employeeJpaDao.editEmployee(employeeId);
			model.addAttribute("employees", employeeJpaDao.getEmployees());
			model.addAttribute("employee", employeeObj);
		} catch (Exception e) {
			return "error";
		}
		return "jpaIndex";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/jpa/employee/search")
	public String getJpaEmployee(Model model, @RequestParam String search) {
		try {
			model.addAttribute("employees", employeeJpaDao.getEmployee(search));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("employeeSearch", search);
		return "jpaIndex";
	}
}
