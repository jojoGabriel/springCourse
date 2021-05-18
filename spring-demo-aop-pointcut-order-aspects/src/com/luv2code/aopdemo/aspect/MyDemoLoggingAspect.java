package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	// @Before("execution(public void add*())")	
	// @Before("execution(void add*())")
	// @Before("execution(* add*(com.luv2code.aopdemo.Account))")
	// @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	// @Before("execution(* add*(..))")
	
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>> Executing @Before advice on method()");
	}
	
}
