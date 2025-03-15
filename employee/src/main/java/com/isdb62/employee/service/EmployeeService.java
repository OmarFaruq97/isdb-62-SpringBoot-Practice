package com.isdb62.employee.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.isdb62.employee.model.Employee;
import com.isdb62.employee.repository.EmployeeRepository;
@Service
public class EmployeeService {
	private final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public Employee saveEmployee(Employee employee) {
		int save = repository.save(employee);
		return getEmpById(save);
	}

	public Employee getEmpById(int id) {
		Optional<Employee> byId = repository.findById(id);
		return byId.get();
	}

}
