package com.ravitech.empmgmt.adviser;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ravitech.empmgmt.dto.ResponseDto;

@ControllerAdvice
public class ErrorHandlingApiAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	ResponseEntity<ResponseDto> onMethodArgumentNotValidException(MethodArgumentNotValidException e) {

		// Commenting this since requirement is to send field error in ResponseDto
		// format and there should be only 1 error message
		List<ValidationError> filedErrors = new ArrayList<ValidationError>();
		ValidationError error = new ValidationError();
		e.getBindingResult().getFieldErrors().forEach(fieldError -> {
			error.addFieldError(fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage(),
					filedErrors);
		});
		error.setFieldErrors(filedErrors);
		return new ResponseEntity<ResponseDto>(
				ResponseDto.builder().data(error).code(0).status(HttpStatus.BAD_REQUEST).build(),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	ResponseEntity<ResponseDto> onConstraintViolationException(ConstraintViolationException e) {
		// Commenting this since requirement is to send field error in ResponseDto
		// format and there should be only 1 error message
		List<ValidationError> filedErrors = new ArrayList<ValidationError>();
		ValidationError error = new ValidationError();
		e.getConstraintViolations().forEach(fieldError -> {
			error.addFieldError((String) fieldError.getInvalidValue(), fieldError.getMessage(), filedErrors);
		});
		error.setFieldErrors(filedErrors);
		return new ResponseEntity<ResponseDto>(
				ResponseDto.builder().data(error).code(0).status(HttpStatus.BAD_REQUEST).build(),
				HttpStatus.BAD_REQUEST);

	}
}
