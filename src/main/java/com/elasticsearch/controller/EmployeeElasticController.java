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

import com.elasticsearch.dao.EmployeeElasticDao;
//import com.elasticsearch.dao.EmployeeJpaDao;
import com.elasticsearch.elastic.entity.Employee;

/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */
@Controller
public class EmployeeElasticController {
	
	@Autowired
	private EmployeeElasticDao employeeElasticDao;
		
	@RequestMapping("/elasticIndex")
	public ModelAndView elasticHome(Model model) {
		try {
			model.addAttribute("employees", employeeElasticDao.getEmployees());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("elasticIndex");
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/elastic/employee/add")
	public ModelAndView addElasticEmployee(@ModelAttribute Employee employee) throws Exception {
		try {
			employeeElasticDao.addEmployee(employee);
		} catch (Exception e) {
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/elasticIndex");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/elastic/employee/delete")
	public ModelAndView deleteElasticEmployee(int employeeId) throws Exception {
		try {
			employeeElasticDao.deleteEmployee(employeeId);
		} catch (Exception e) {
			return new ModelAndView("redirect:/error");
		}
		return new ModelAndView("redirect:/elasticIndex");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/elastic/employee/edit")
	public String editElasticEmployee(Model model, int employeeId) throws Exception {
		Employee employeeObj = null;
		try {
			employeeObj = employeeElasticDao.editEmployee(employeeId);
			model.addAttribute("employees", employeeElasticDao.getEmployees());
			model.addAttribute("employee", employeeObj);
		} catch (Exception e) {
			return "error";
		}
		return "elasticIndex";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/elastic/employee/search")
	public String getElasticEmployee(Model model, @RequestParam String search) {
		try {
			model.addAttribute("employees", employeeElasticDao.getEmployee(search));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("employeeSearch", search);
		return "elasticIndex";
	}	
}
