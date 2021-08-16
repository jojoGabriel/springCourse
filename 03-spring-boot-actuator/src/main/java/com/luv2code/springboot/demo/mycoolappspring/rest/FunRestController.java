package com.luv2code.springboot.demo.mycoolappspring.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
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
}
