package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.util.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(int theSortField) {
		
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		String theFieldName = null;
		
		switch(theSortField) {
		case SortUtils.FIRST_NAME:
			theFieldName = "firstName";
			break;
		case SortUtils.LAST_NAME:
			theFieldName = "lastName";
			break;
		case SortUtils.EMAIL:
			theFieldName = "email";
			break;
		default:
			theFieldName = "lastName";
		}
		
		
		// create query
		String queryString = "from Customer order by " + theFieldName;
		
		Query<Customer> theQuery = currentSession.createQuery(queryString, 
				Customer.class);
		
		// get result set
		List<Customer> customers = theQuery.getResultList();
		
		// return list

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		if (theSearchName != null && theSearchName.trim().length() > 0 ) {
			
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

}
