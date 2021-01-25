package com.ravitech.empmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravitech.empmgmt.dto.ResponseDto;
import com.ravitech.empmgmt.model.Employee;
import com.ravitech.empmgmt.service.EmployeeService;

/**
 * @author Ravindra
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<ResponseDto> addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/getAllEmployee") 
	public ResponseEntity<ResponseDto> findAllEmployee() {
		return employeeService.findAllEmployee();
	}
	
	@GetMapping("/findEmplyeeById/{id}") 
	public ResponseEntity<ResponseDto> findEmplyeeById(@PathVariable("id")Long id) {
		return employeeService.findAllEmployee(id);
	}
	
	@GetMapping("/findEmplyeeByMobile/{mobile}") 
	public ResponseEntity<ResponseDto> findEmplyeeByMobile(@PathVariable("mobile")String mobile) {
		return employeeService.findEmplyeeByMobile(mobile);
	}
}
