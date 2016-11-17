/**
 * 
 */
package com.elasticsearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.elasticsearch.entity.Employee;

/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */
@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, Integer> {

	/**
	 * @param search
	 * @param search2
	 * @param search3
	 * @param search4
	 * @return
	 */
	List<Employee> findByFirstNameContainingOrLastNameContainingOrLanguageContainingOrDepartmentContainingOrderByEmployeeIdAsc(String search, String search2, String search3, String search4);

	Employee findByEmployeeId(int employeeId);
	
	List<Employee> findByFirstNameContainingOrderByEmployeeIdAsc(String name);
}
