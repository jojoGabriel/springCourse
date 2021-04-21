package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Duffy", "Duck", "duffy@email.com");
			
			
			// start trans
			session.beginTransaction();
			
			// save student
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit
			session.getTransaction().commit();
			
			System.out.println("generated id: " + tempStudent.getId());
			
			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			// retrieve a student
			System.out.println("Getting student: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Got this: " + myStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
			
		}

	}

}
