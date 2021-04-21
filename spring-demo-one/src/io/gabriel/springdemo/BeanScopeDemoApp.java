package io.gabriel.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load spring config
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean
		Coach alphaCoach = context.getBean("myCoach", Coach.class );
		
		Coach betaCoach = context.getBean("myCoach", Coach.class );
		
		// check if same
		boolean same = (alphaCoach == betaCoach);
		
		System.out.println("Same: " + same);

		System.out.println("Alpha: " + alphaCoach);
		
		System.out.println("Beta: " + betaCoach);
				
		context.close();
		
	}

}
