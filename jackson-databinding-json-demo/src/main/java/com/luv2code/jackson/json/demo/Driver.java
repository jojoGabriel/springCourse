package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read the json file to java pojo
			Student student = mapper.readValue(
					new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("First name = " + student.getFirstName());
			System.out.println("Last name = " + student.getLastName());
			System.out.println("Address = " + student.getAddress());
			
			for (String lang : student.getLanguages()) {
				System.out.println("Language(s) = " + lang);
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
