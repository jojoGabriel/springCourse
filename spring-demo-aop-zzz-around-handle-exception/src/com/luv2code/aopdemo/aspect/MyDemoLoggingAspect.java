package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n========>> Executing @Around on method: " + method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		

			try {
				result = theProceedingJoinPoint.proceed();
			} catch (Exception e) {
				myLogger.warning(e.getMessage());
				// result = "Major accident! But no worries.";
				throw e;
			}
		
		long end = System.currentTimeMillis();
		
		long duration = end -  begin;
		
		myLogger.info("\n=====> Duration: " + duration / 1000.0 + " seconds" );

		
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========>> Executing @After (finally) on method: " + method);
		
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========>> Executing @AfterThrowing on method: " + method);
		
		myLogger.info("\n========>> Exception is: " + theExc);
		
	}
	
	
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// method ran
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========>> Executing @AfterReturning on method: " + method);
		
		// print result
		myLogger.info("\n========>> Result is: " + result);
		
		// change result
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n========>> Result is: " + result);
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
		myLogger.info("\n======>>> Executing @Before advice on method()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJointPoint.getSignature();
		
		myLogger.info("Method: " + methodSig);
		
		// display method arguments
		
		// get args
		Object[] args = theJointPoint.getArgs();
		
		for (Object arg : args) {
			myLogger.info( arg.toString());
			
			if (arg instanceof Account) {
				
				Account acct = (Account) arg;
				
				myLogger.info("account name: " + acct.getName());
				myLogger.info("account level: " + acct.getLevel());
			}
		}
		
	}
	
	
	
	
	
	
}
