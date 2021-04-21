package io.gabriel.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	
	private String[] data = {
			"first",
			"second",
			"third"
	};
	
	Random random = new Random();
	
	@Override
	public String getFortune() {
		return data[random.nextInt(data.length)];
	}

}
