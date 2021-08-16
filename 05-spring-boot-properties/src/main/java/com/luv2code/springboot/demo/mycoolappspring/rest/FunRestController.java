package com.luv2code.springboot.demo.mycoolappspring.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	private String coachName;
	
	
	@Value("${team.name}")
	private String teamName;
	
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Server time is " + LocalDateTime.now();
	}

	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Play Bball";
	}
	
	@GetMapping("/fortune")
	public String getFortune() {
		return "blessed day";
	}
	
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach: " + coachName + ", Team Name: " + teamName;
	}
}
