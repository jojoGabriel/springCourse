package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMemberAccount() {
		
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
		
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + ": SLEEPING");
		
	}
}
