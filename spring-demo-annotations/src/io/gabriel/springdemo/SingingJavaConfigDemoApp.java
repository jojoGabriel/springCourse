package io.gabriel.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingingJavaConfigDemoApp {
	
	public static void main(String[] args) {
		// read spring config class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SingingConfig.class);
		
		// get the bean from spring container
		SingingCoach coach = context.getBean("singingCoach", SingingCoach.class);

		
		// call bean method
		System.out.println(coach.getDailyWorkout());

		
		// call method that has dependency
		System.out.println(coach.getDailyFortune());
		
		
		// close context
		context.close();
	}

}
