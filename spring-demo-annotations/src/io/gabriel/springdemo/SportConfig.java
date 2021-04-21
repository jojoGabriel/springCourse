package io.gabriel.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("io.gabriel.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define bean for fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	// define bean for dive coach and inject dependency
	@Bean
	public Coach diveCoach() {
		return new DiveCoach(sadFortuneService());
	}
	
	

}
