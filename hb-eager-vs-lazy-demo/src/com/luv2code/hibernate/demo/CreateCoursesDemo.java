package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
					
			// create the objects
						
			Instructor instructor = new Instructor("Gabriel", "Jojo", "jojo@email.com");
			
			InstructorDetail detail = new InstructorDetail(
					"http://www.youtube.com",
					"coding");
			
			
			// associate the objects
			instructor.setInstructorDetail(detail);
			
			// start trans
			session.beginTransaction();

			System.out.println("Saving instructor: " + instructor);
			// save the instructor (will also save the detail)
			session.save(instructor);
			
			
			// commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			
			session.close();
			factory.close();
			
		}

	}

}
