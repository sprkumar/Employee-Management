package com.ravitech.empmgmt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ravitech.empmgmt.dto.ResponseDto;
import com.ravitech.empmgmt.model.Employee;
import com.ravitech.empmgmt.repository.EmployeeRepostory;
import com.ravitech.empmgmt.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ravindra
 *
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepostory employeeRepository;

	@Override
	public ResponseEntity<ResponseDto> addEmployee(Employee employee) {
		log.debug("addEmployee method started");
		ResponseDto responseDto = null;
		try {
			employee = employeeRepository.save(employee);
			return new ResponseEntity<ResponseDto>(responseDto = ResponseDto.builder().action("Success").data(0)
					.message("Employee Created Successfully").build(), HttpStatus.OK);
		} catch (Exception e) {
		}
		log.info("Employee added Successfully");
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getStatus());
	}

	@Override
	public ResponseEntity<ResponseDto> findAllEmployee() {
		log.debug("findAllEmployee method started");
		ResponseDto responseDto = null;
		try {
			List<Employee> employeeLst = employeeRepository.findAll();
			return new ResponseEntity<ResponseDto>(responseDto = ResponseDto.builder().action("success")
					.data(employeeLst).message("Data successfully fetched").build(), HttpStatus.OK);

		} catch (Exception e) {
		}
		log.info("Employee fetch Successfully");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto> findAllEmployee(Long id) {
		log.debug("findAllEmployee method started");
		ResponseDto responseDto = null;
		try {
			Optional<Employee> employee = employeeRepository.findById(id);
			responseDto = ResponseDto.builder().message("Employee data fetch Successfully").data(employee.get())
					.action("Success").build();
		} catch (Exception e) {
		}
		log.info("Employee data fetch Successfully");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ResponseDto> findEmplyeeByMobile(String mobile) {
		log.debug("findEmplyeeByMobile method started");
		ResponseDto responseDto = null;

		try {
			List<Employee> empData = employeeRepository.findEmplyeeByMobile(mobile);
			responseDto = ResponseDto.builder().message("Data fetch successfully").data(empData).action("Success")
					.build();
		} catch (Exception e) {
		}
		log.info("Employee data fetch Successfully");
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
	}

}
