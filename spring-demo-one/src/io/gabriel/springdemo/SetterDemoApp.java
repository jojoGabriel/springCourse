package io.gabriel.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		// load config
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from container
		CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);
		
		
		// call the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmailAddress());
		System.out.println(coach.getTeam());
		
		// close context
		context.close();

	}

}
