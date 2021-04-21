package io.gabriel.springdemo;

public class DrivingCoach implements Coach {
	
	private FortuneService fortuneService;

	public DrivingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Drive 200 km per hour";
	}

	@Override
	public String getDailyFortune() {
		return "drive. " + fortuneService.getFortune();
	}

}
