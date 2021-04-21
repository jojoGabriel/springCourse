package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
					
			// create students
			System.out.println("Creating students");
			Student tempStudent1 = new Student("John", "Doe", "johndoe@email.com");
			Student tempStudent2 = new Student("Mary", "Public", "marypublic@email.com");
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonitaapplebum@email.com");
			
			// start trans
			session.beginTransaction();
			
			// save student
			System.out.println("saving students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
			
		}

	}

}
