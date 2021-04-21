package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
					
			
			
			// start trans
			session.beginTransaction();

			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudents);
			
			
			// query with where
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
					
			// display students
			System.out.println("\n\nfiltered...\n\n");
			displayStudents(theStudents);
			
			
			// query with OR
			theStudents = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Duffy'").getResultList();
			
			System.out.println("\n\nOR\n\n");
			displayStudents(theStudents);
			
			// using like
			
			theStudents = session.createQuery("from Student s where s.email like '%email.com'").getResultList();
			System.out.println("\n\nLIKE\n\n");
			displayStudents(theStudents);
			
			// commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
			
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

}
