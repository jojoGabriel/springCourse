package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
					
			
			// start trans
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Pacman");
			
			
			// add some reviews
			tempCourse.addReview(new Review("Great course!"));
			tempCourse.addReview(new Review("Cool course!"));
			tempCourse.addReview(new Review("Dumb course!"));
			
			// save the course ... and leverage the cascade all
			System.out.println("Saving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
				
			session.save(tempCourse);

			// commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			
			session.close();
			factory.close();
			
		}

	}

}
