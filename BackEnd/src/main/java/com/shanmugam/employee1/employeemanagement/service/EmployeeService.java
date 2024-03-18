package com.shanmugam.employee1.employeemanagement.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shanmugam.employee1.employeemanagement.exception.UserNotFoundException;
import com.shanmugam.employee1.employeemanagement.model.Employee;
import com.shanmugam.employee1.employeemanagement.repo.EmployeeRepo;

@Service
public class EmployeeService {

	private final EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}

	public List<Employee> findAllEmployee() {
		return employeeRepo.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Transactional
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}

	public Employee findEmpolyeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User ID" + id + "was not Found"));
	}

}
