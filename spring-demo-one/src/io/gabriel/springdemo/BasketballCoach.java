package io.gabriel.springdemo;

public class BasketballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public BasketballCoach() {}
	
	public BasketballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Shoot 100 free throws";
	}

	@Override
	public String getDailyFortune() {
		return "Shoot it. " + fortuneService.getFortune();
	}

}
