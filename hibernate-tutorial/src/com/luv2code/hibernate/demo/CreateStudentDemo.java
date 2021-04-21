package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
					
			// create student
			System.out.println("Creating student");
			Student tempStudent = new Student("Paul", "Wall", "paul@email.com");
			
			
			// start trans
			session.beginTransaction();
			
			// save student
			session.save(tempStudent);
			
			// commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
			
		}

	}

}
