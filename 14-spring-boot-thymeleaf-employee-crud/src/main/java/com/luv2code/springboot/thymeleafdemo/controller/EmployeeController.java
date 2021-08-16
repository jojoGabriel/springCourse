package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService anEmployeeService) {
		employeeService = anEmployeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		List<Employee> employees = employeeService.findAll();
		
		theModel.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model aModel) {
		
		Employee employee = new Employee();
		
		aModel.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		employeeService.save(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,
			                        Model theModel)  {
		Employee employee = employeeService.findById(theId);
		
		theModel.addAttribute("employee", employee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/delete") 
	public String delete(@RequestParam("employeeId") int theId,
			             Model theModel) {
		employeeService.deleteById(theId);
		
		return "redirect:/employees/list";
	}
	

}
