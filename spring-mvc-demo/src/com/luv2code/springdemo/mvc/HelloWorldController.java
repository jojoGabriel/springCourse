package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	// show initial form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// process the form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read form data and
	// add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDue(HttpServletRequest request, Model model) {
		
		// read request param from form
		String theName = request.getParameter("studentName");
		
		// convert data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model) {
		

		// convert data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey My Friend! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}

}
