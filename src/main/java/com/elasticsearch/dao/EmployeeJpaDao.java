/**
 * 
 */
package com.elasticsearch.dao;

import java.util.List;

import com.elasticsearch.jpa.entity.EmployeeJpa;

/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */

public interface EmployeeJpaDao {
	public EmployeeJpa addEmployee(EmployeeJpa employee) throws Exception;
	
	public List<EmployeeJpa> getEmployees() throws Exception;

	public List<EmployeeJpa> getEmployee(String search) throws Exception;
	
	public void deleteEmployee(int employeeId) throws Exception;

	public EmployeeJpa editEmployee(int employeeId) throws Exception;	
	
}
