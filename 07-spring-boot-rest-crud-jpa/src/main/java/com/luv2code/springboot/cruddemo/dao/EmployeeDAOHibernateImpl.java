package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager anEntityManager) {
		entityManager = anEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery  = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employee = theQuery.getResultList();
				
		return employee;
	}

	@Override
	public Employee findById(int anId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, anId);	
		
		return employee;
	}

	@Override
	public void save(Employee anEmployee) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(anEmployee);
		
	}

	@Override
	public void deleteById(int anId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery  = currentSession.createQuery(
				"delete from Employee where id = :employeeId");
		
		theQuery.setParameter("employeeId",  anId);
		
		theQuery.executeUpdate();
	}
	
	
	
	
	

}
