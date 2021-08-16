package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository anEmployeeRepository) {
		employeeRepository = anEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int anId) {
		
		Optional<Employee> result = employeeRepository.findById(anId);
		
		Employee employee = null;
		
		if (result.isPresent()) {
			employee = result.get();
		} else {
			throw new RuntimeException("Did not find the employee id: " + anId);
		}
		return employee;
	}
	

	@Override
	public void save(Employee anEmployee) {
		employeeRepository.save(anEmployee);	
	}

	@Override
	public void deleteById(int anId) {
		employeeRepository.deleteById(anId);	
	}

}
