package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
						
			// start trans
			session.beginTransaction();

			// get instructor by id
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Found " + instructor);
			
			// delete the instructors
			if (instructor != null) {
				System.out.println("about to delete: " + instructor);
				session.delete(instructor);
			}
			
			
			
			// commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
			
		}

	}

}
