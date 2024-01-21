package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.UserDetails;
import com.nt.repo.UserDetailsRepo;
@Component
public class TestOperationRunner implements CommandLineRunner {

	@Autowired
	UserDetailsRepo detailsRepo;
	
	
	@Override
	public void run(String... args) throws Exception{
		
		UserDetails details1 = new UserDetails();
		details1.setUserId(103);
		details1.setActiveSwitch("Y");
		details1.setEmailAddress("Aniket@gmail.com");
		details1.setMobileNumber("955781388");
		details1.setUserName("aniket");
		
	System.out.println("Hello");
		
		
		

	}

}
