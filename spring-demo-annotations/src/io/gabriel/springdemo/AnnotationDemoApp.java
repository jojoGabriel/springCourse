package io.gabriel.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		// read spring config
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach coach = context.getBean("tennisCoach", Coach.class);
		Coach swim = context.getBean("swimmingCoach", Coach.class);
		
		// call bean method
		System.out.println(coach.getDailyWorkout());
		System.out.println(swim.getDailyWorkout());
		
		// call method that has dependency
		System.out.println(coach.getDailyFortune());
		
		
		// close context
		context.close();

	}

}
