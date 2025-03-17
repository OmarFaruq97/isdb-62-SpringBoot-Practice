package com.isdb62.employee.service;

import java.util.List;
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

	public List<Employee> getAllEmp() {
		List<Employee> all = repository.findAll();		
		return all;
	}

	public void deleteById(int id) {
		repository.deleteById(id);		
	}

	public Employee updateEmp(int id, Employee employee) {
		employee.setId(id);
		repository.update(employee);
		return getEmpById(id);
	}

	public  List<Employee> getempByname(String name) {	
		List<Employee> name1 = repository.findByName(name);
		return name1;
	}	
}