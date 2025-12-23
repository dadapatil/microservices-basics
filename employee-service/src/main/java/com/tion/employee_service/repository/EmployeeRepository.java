package com.tion.employee_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tion.employee_service.model.Employee;

@Repository
public class EmployeeRepository {

	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private List<Employee> employees = new ArrayList<>();
	
	public Employee addEmployee(Employee employee) {
		LOGGER.info("EmployeeRepository add  : ");
		employees.add(employee);
		
		return employee;
	}
	
	public Employee findById(Long id) {
		return employees.stream()
				.filter(e -> e.id().equals(id))
				.findFirst()
				.orElseThrow();
	}
	
	public List<Employee> findAll(){
		LOGGER.info("EmployeeRepository findAll  : ");
		employees.stream().forEach(a -> System.out.println(a.toString()));
		return employees;
	} 
	
	public List<Employee> findByDepartmentId(Long id) {
		return employees.stream()
				.filter(e -> e.departmentId().equals(id))
				.toList();
 
	}
}
