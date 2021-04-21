package io.gabriel.springdemo;

public class SingingCoach implements Coach {
	
	private FortuneService fortuneService;
	
	
	public SingingCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Vocalization for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
