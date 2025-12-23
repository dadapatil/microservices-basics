package com.tion.department_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tion.department_service.model.Department;

@Repository
public class DepartmentRepository {

	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private List<Department> departments = new ArrayList<>();
	
	public Department addDepartment(Department department) {
		departments.add(department);
		
		return departments.stream().filter(d -> d.getId().equals(department.getId())).findFirst().get();
	}
	
	public Department findById(Long id) {
		return departments.stream()
				.filter(e -> e.getId().equals(id))
				.findFirst()
				.orElseThrow();
	}
	
	public List<Department> findAll(){
		LOGGER.info("DepartmentRepository findAll  : ");
		departments.stream().forEach(a -> System.out.println(a.toString()));
		return departments;
	} 
}

