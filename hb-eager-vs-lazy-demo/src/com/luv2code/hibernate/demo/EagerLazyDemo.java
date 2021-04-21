package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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

			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("jojo Instructor: " + instructor);
			
			System.out.println("jojo Courses: " + instructor.getCourses());

			// commit
			session.getTransaction().commit();
			
			// close session
			session.close();
			
			System.out.println("\njojo The session is now closed!\n");
			
			System.out.println("jojo Courses: " + instructor.getCourses());
			
			System.out.println("jojo Done");
			
		} finally {
			
			session.close();
			factory.close();
			
		}

	}

}
