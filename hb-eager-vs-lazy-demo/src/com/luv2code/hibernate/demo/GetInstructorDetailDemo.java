package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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

			// get the instructor detail object
			int id = 2;
			
			InstructorDetail detail = session.get(InstructorDetail.class, id);
				
			// print instructor detail
			System.out.println("detail: " + detail);

			// print associate instructor
			System.out.println("instructor: " + detail.getInstructor());
			
			// commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} catch(Exception x) {
			x.printStackTrace();
			
		} finally {
			session.close();
			factory.close();
			
		}

	}

}
