package com.ravitech.empmgmt.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


/**
 * @author Ravindra
 *
 */
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValuesAllowedValidator.class })
public @interface ValuesAllowed {

	String message() default "Field value should be from list of ";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String propName();

	String[] values();
}