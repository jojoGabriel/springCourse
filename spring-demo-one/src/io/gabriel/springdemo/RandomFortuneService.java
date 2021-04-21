package io.gabriel.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	
	private String[] data = {
			"first",
			"second",
			"third"
	};

	private Random random = new Random();
	
	@Override
	public String getFortune() {
		
		int i = random.nextInt(data.length);
		return data[i];
	}

}
