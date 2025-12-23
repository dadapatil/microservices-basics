package com.tion.employee_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tion.employee_service.controller.EmployeeController;
import com.tion.employee_service.model.Employee;
import com.tion.employee_service.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Employee add  : "+employee );
		
		return repository.addEmployee(employee);
	}
	
	@GetMapping("/{id}")
	public Employee findEmployeeById(@PathVariable Long id) {
		LOGGER.info("Employee findEmployeeById  : "+id );
		return repository.findById(id);
		
	}
	
	@GetMapping
	public List<Employee> findAll(){
		LOGGER.info("Employee findAll  : ");
		return repository.findAll();
	}
	
	@GetMapping("/department/{departmentId}")
	public List<Employee> findEmployeesByDepartmentId(@PathVariable Long departmentId) {
		LOGGER.info("Employee findEmployeesByDepartmentId  : "+departmentId );
		return repository.findByDepartmentId(departmentId);   
		
	}
	
	
}
