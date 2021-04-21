package io.gabriel.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach coach = context.getBean("myCoach", Coach.class);
		
		// call method on the bean
		System.out.println(coach.getDailyWorkout());
		
		// call the new method from dependency
		System.out.println(coach.getDailyFortune());
		
		// close the context
		context.close();

	}

}
