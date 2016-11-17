/**
 * 
 */
package com.elasticsearch.dao;

import java.util.List;

import com.elasticsearch.entity.Employee;

/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */
public interface EmployeeDao {

	public Employee addEmployee(Employee employee) throws Exception;
	
	public List<Employee> getEmployees() throws Exception;

	public List<Employee> getEmployee(String search) throws Exception;
	
	public void deleteEmployee(int employeeId) throws Exception;

	public Employee editEmployee(int employeeId) throws Exception;	
	
}
