package io.gabriel.springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {

		return "Sad day :-( ";
	}

}
