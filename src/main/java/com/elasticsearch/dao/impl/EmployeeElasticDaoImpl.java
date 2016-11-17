/**
 * 
 */
package com.elasticsearch.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elasticsearch.dao.EmployeeElasticDao;
import com.elasticsearch.elastic.entity.Employee;
import com.elasticsearch.elastic.repository.EmployeeElasticRepository;


/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */
@Service
public class EmployeeElasticDaoImpl implements EmployeeElasticDao{

	@Autowired
	EmployeeElasticRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) throws Exception {
		Employee employeeObj=null;
		try {
			employeeObj = employeeRepository.save(employee);
		} catch (Exception e) {
		}
		return employeeObj;
	}

	@Override
	public List<Employee> getEmployees() throws Exception {
		Iterable<Employee> employeeObj=null;
		try {
			employeeObj = employeeRepository.findByFirstNameContainingOrderByEmployeeIdAsc("");
		} catch (Exception e) {
		}
		return (List<Employee>) employeeObj;
	}
	
	@Override
	public List<Employee> getEmployee(String search) throws Exception {
		List<Employee> employeeObj=null;
		try {
			employeeObj = employeeRepository.findByFirstNameContainingOrLastNameContainingOrLanguageContainingOrDepartmentContainingOrderByEmployeeIdAsc(search, search, search, search);
		} catch (Exception e) {
		}
		return employeeObj;
	}
	
	@Override
	public void deleteEmployee(int employeeId) throws Exception {
		try {
				employeeRepository.delete(employeeId);
		} catch (Exception e) {
		}
	}
	
	@Override
	public Employee editEmployee(int employeeId) throws Exception {
		Employee employeeObj=null;
		try {
			employeeObj=employeeRepository.findByEmployeeId(employeeId);
		} catch (Exception e) {
		}
		return employeeObj;
	}
}
