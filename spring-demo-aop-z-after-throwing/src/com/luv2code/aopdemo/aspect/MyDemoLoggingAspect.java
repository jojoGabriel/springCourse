package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>> Executing @AfterThrowing on method: " + method);
		
		System.out.println("\n========>> Exception is: " + theExc);
		
	}
	
	
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// method ran
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========>> Executing @AfterReturning on method: " + method);
		
		// print result
		System.out.println("\n========>> Result is: " + result);
		
		// change result
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n========>> Result is: " + result);
	}
	
	
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for (Account acct : result) {
			acct.setName(acct.getName().toUpperCase());
			
		}
		
	}




	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	// @Before("execution(public void add*())")	
	// @Before("execution(void add*())")
	// @Before("execution(* add*(com.luv2code.aopdemo.Account))")
	// @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	// @Before("execution(* add*(..))")
	
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJointPoint) {
		System.out.println("\n======>>> Executing @Before advice on method()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJointPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJointPoint.getArgs();
		
		for (Object arg : args) {
			System.out.println(arg);
			
			if (arg instanceof Account) {
				
				Account acct = (Account) arg;
				
				System.out.println("account name: " + acct.getName());
				System.out.println("account level: " + acct.getLevel());
			}
		}
		
	}
	
	
	
	
	
	
}
