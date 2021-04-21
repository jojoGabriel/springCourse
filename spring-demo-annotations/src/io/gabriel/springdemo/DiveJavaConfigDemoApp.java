package io.gabriel.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiveJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		DiveCoach coach = context.getBean("diveCoach", DiveCoach.class);

		
		// call bean method
		System.out.println(coach.getDailyWorkout());

		
		// call method that has dependency
		System.out.println(coach.getDailyFortune());
		
		System.out.println(coach.getEmail());
		System.out.println(coach.getTeam());
		
		// close context
		context.close();

	}

}
