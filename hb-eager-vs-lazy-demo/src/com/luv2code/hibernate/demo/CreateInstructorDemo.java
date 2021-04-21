package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
												
			// start trans
			session.beginTransaction();

			// get instructor from db
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
	
			// create courses 
			Course course1 = new Course("Air Guitar");
			Course course2 = new Course("Pinball");
			
			// add courses to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			
			// save the courses
			session.save(course1);
			session.save(course2);
			
			// commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			
			session.close();
			factory.close();
			
		}

	}

}
