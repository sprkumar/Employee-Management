package com.ravitech.empmgmt.adviser;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author Ravindra
 *
 */
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ValidationError {
	
	private String fieldName;
	private Object fieldValue;
	private Object fieldError;
	private List<ValidationError> fieldErrors;

	public ValidationError(String filedName, String fieldError) {
		this.fieldName = filedName;
		this.fieldError = fieldError;
	}
	
	public ValidationError(String fieldName, Object fieldValue, Object fieldError) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.fieldError = fieldError;
	}
	
	public List<ValidationError> addFieldError(String filedName, String fieldError, List<ValidationError> filedErrors) {
		filedErrors.add(new ValidationError(filedName, fieldError));
		return filedErrors;
	}
	
	public List<ValidationError> addFieldError(String filedName, Object fieldValue, String fieldError, List<ValidationError> filedErrors) {
		filedErrors.add(new ValidationError(filedName, fieldValue, fieldError));
		return filedErrors;
	}	
}

