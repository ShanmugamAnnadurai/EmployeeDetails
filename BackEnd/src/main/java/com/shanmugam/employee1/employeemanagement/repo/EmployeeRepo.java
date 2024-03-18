package com.shanmugam.employee1.employeemanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shanmugam.employee1.employeemanagement.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	void deleteEmployeeById(Long id);

	Optional<Employee> findEmployeeById(Long id);

}
