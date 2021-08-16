package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	public EmployeeDAOJpaImpl(EntityManager anEntityManager) {
		entityManager = anEntityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		Query theQuery = entityManager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int anId) {		
		Employee employee = entityManager.find(Employee.class, anId);		
		return employee;
	}

	@Override
	public void save(Employee anEmployee) {		
		Employee employee = entityManager.merge(anEmployee);
		anEmployee.setId(employee.getId());
	}

	@Override
	public void deleteById(int anId) {
		Query query = entityManager.createQuery(
				"delete from Employee where id = :employeeId");
		query.setParameter("employeeId", anId);
		query.executeUpdate();
	}

}
