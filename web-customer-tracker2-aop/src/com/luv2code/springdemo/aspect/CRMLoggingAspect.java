package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {

	// set up logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// set pointcut declaration
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display called method
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=======>> in @Before: calling method: " + theMethod);
		
		// display method arguments
		Object[] args = theJoinPoint.getArgs();
		
		for (Object arg : args) {
			myLogger.info("=====>> argument: " + arg);
		}
		
	}
	
	// add @AfterReturning
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display called method
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=======>> in @AfterReturning: from method: " + theMethod);
		
		// display method output
		myLogger.info("=====>> result: " + theResult);
	}
	
	
	
}
