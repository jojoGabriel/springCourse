package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {
	
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theAccounts = null;
		
		try {
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
			
			
			
			
		} catch (Exception x) {
			System.out.println("\n\nMain Program ... caught exception: " + x);
		}
		
		System.out.println("\n\nMain Program: After Throwing Demo App");
		System.out.println("-----------");
		System.out.println(theAccounts);
		System.out.println("\n----------");
		
		// close the context
		context.close();
		
	}

}