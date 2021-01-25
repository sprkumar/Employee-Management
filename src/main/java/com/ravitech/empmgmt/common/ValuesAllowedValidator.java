package com.ravitech.empmgmt.common;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * @author Ravindra
 *
 */
public class ValuesAllowedValidator implements ConstraintValidator<ValuesAllowed, String> {
	private String propName;
	private String message;
	private List<String> allowable;

	@Override
	public void initialize(ValuesAllowed requiredIfChecked) {
		this.propName = requiredIfChecked.propName();
		this.message = requiredIfChecked.message();
		this.allowable = Arrays.asList(requiredIfChecked.values());
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		Boolean valid = value == null || this.allowable.contains(value);

		if (!valid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message.concat(this.allowable.toString()))
					.addPropertyNode(this.propName).addConstraintViolation();
		}
		return valid;
	}
}
