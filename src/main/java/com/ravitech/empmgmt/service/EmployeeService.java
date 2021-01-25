package com.ravitech.empmgmt.service;

import org.springframework.http.ResponseEntity;

import com.ravitech.empmgmt.dto.ResponseDto;
import com.ravitech.empmgmt.model.Employee;

/**
 * @author Ravindra
 *
 */
public interface EmployeeService {
	
	public ResponseEntity<ResponseDto> addEmployee(Employee employee);

	public ResponseEntity<ResponseDto> findAllEmployee();

	public ResponseEntity<ResponseDto> findAllEmployee(Long id);

	public ResponseEntity<ResponseDto> findEmplyeeByMobile(String mobile);
}
