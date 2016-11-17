/**
 * 
 */
package com.elasticsearch.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elasticsearch.dao.EmployeeJpaDao;
import com.elasticsearch.jpa.entity.EmployeeJpa;
import com.elasticsearch.jpa.repository.EmployeeJpaRepository;


/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */
@Service
public class EmployeeJpaDaoImpl implements EmployeeJpaDao {

	@Autowired
	EmployeeJpaRepository employeeJpaRepository;
	
	@Override
	public EmployeeJpa addEmployee(EmployeeJpa employee) throws Exception {
		EmployeeJpa employeeObj=null;
		try {
			employeeObj = employeeJpaRepository.save(employee);
		} catch (Exception e) {
		}
		return employeeObj;
	}

	@Override
	public List<EmployeeJpa> getEmployees() throws Exception {
		Iterable<EmployeeJpa> employeeObj=null;
		try {
			employeeObj = employeeJpaRepository.findAll();
		} catch (Exception e) {
		}
		return (List<EmployeeJpa>) employeeObj;
	}
	
	@Override
	public List<EmployeeJpa> getEmployee(String search) throws Exception {
		List<EmployeeJpa> employeeObj=null;
		try {
			employeeObj = employeeJpaRepository.findByFirstNameContainingOrLastNameContainingOrLanguageContainingOrDepartmentContainingOrderByEmployeeIdAsc(search, search, search, search);
		} catch (Exception e) {
		}
		return employeeObj;
	}
	
	@Override
	public void deleteEmployee(int employeeId) throws Exception {
		try {
			employeeJpaRepository.delete(employeeId);
		} catch (Exception e) {
		}
	}
	
	@Override
	public EmployeeJpa editEmployee(int employeeId) throws Exception {
		EmployeeJpa employeeObj=null;
		try {
			employeeObj=employeeJpaRepository.findByEmployeeId(employeeId);
		} catch (Exception e) {
		}
		return employeeObj;
	}
}
