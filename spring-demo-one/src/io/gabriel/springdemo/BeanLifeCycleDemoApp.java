package io.gabriel.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {

		// load spring config
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// retrieve bean
		Coach coach = context.getBean("myCoach", Coach.class );
		
		System.out.println(coach.getDailyWorkout());
				
		context.close();
		
	}

}
