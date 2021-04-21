package io.gabriel.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingingConfig {
	
	@Bean
	public FortuneService popFortuneService() {
		return new PopFortuneService();
	}
	
	@Bean
	public Coach singingCoach() {
		return new SingingCoach(popFortuneService());
	}

}
