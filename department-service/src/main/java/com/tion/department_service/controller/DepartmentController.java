package com.tion.department_service.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tion.department_service.client.EmployeeClient;
import com.tion.department_service.config.WebClientConfig;
import com.tion.department_service.model.Department;
import com.tion.department_service.model.Employee;
import com.tion.department_service.repository.DepartmentRepository;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private WebClientConfig webClientConfig;
	
//	@Autowired
//	private EmployeeClient employeeClient;
	
	@PostMapping
	public Department add(@RequestBody Department department) {
		LOGGER.info("Department add  : "+department );
		
		return repository.addDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable Long id) {
		LOGGER.info("Department findDepartmentById  : "+id );
		return repository.findById(id);
		
	}
	
	@GetMapping
	public List<Department> findAll(){
		LOGGER.info("Department findAll  : ");
		return repository.findAll();
	}
	
	@GetMapping("/with-employees")
	public List<Department> findAllwithEmployees(){
		LOGGER.info("Department findAll  : ");
		List<Department> departments = repository.findAll();
		LOGGER.info("Department findAllwithEmployees  : ");
		
		departments.forEach(
				department -> department.setEmployees(webClientConfig.employeeWebClient().build().get()
		                .uri("lb://employee-service/employee/department/{departmentId}",department.getId())
		                .retrieve()
		                .toEntityList(Employee.class)
		                .block()
		                .getBody()));
		
		return departments;
	}
}
