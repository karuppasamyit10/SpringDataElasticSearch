/**
 * 
 */
package com.elasticsearch.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elasticsearch.jpa.entity.EmployeeJpa;

/**
 * @author Karuppu
 * @created on Nov 17, 2016
 * SpringDataElastic
 */
@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeJpa, Integer> {

	/**
	 * @param search
	 * @param search2
	 * @param search3
	 * @param search4
	 * @return
	 */
	List<EmployeeJpa> findByFirstNameContainingOrLastNameContainingOrLanguageContainingOrDepartmentContainingOrderByEmployeeIdAsc(String search, String search2, String search3, String search4);

	EmployeeJpa findByEmployeeId(int employeeId);
	
//	List<Employee> findByFirstNameContainingOrderByEmployeeIdAsc(String name);
}
