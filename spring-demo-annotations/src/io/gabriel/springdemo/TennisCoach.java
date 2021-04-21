package io.gabriel.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService) {
//		super();
//		this.fortuneService = fortuneService;
//	}
	
	public TennisCoach() {
		System.out.println("TennisCoach: at default constructor");
	}
	

	@Override
	public String getDailyWorkout() {
		return "Practice backhand";
	}



	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}


//	@Autowired
//	public void anyMethodName(FortuneService fortuneService) {
//		System.out.println("TennisCoach: at anyMethodName");
//		this.fortuneService = fortuneService;
//	}
	
	
	@PostConstruct
	private void init() {
		System.out.println("Initialization");
	}
	
	@PreDestroy
	private void exit() {
		System.out.println("Exiting");
	}
	
	
	

}
