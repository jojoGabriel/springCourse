package io.gabriel.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		Coach coach = context.getBean("tennisCoach", Coach.class);

		
		// call bean method
		System.out.println(coach.getDailyWorkout());

		
		// call method that has dependency
		System.out.println(coach.getDailyFortune());
		
		
		// close context
		context.close();

	}

}
