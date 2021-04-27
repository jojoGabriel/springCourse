package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
					
			
			// start trans
			session.beginTransaction();
			
			// create a course
			Course tempCourse = new Course("Pacman");
			
			// save the course
			System.out.println("\nSaving the Course");			
			session.save(tempCourse);
			System.out.println("\nSaved the Course: " + tempCourse);
			
			// create the students
			Student tempStudent1 = new Student("John", "Doe", "john@email.com");
			Student tempStudent2 = new Student("Mary", "Poppins", "mary@email.com");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			// save students
			System.out.println("\nSaving Students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Save Students: " + tempCourse.getStudents());

			// commit
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			
			session.close();
			factory.close();
			
		}

	}

}
