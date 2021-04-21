package io.gabriel.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class DiveCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public DiveCoach(FortuneService fortuneServiceArg) {
		fortuneService = fortuneServiceArg;
	}

	@Override
	public String getDailyWorkout() {
		return "Dive from 10 meters";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	

}
