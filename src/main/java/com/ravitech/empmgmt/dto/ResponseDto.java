package com.ravitech.empmgmt.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ravindra
 *
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ResponseDto{

	private String action;
	private String result;
	private String message;
	private Object values;
	private Object data;
	private Integer code;
	private HttpStatus status;

	public ResponseDto() {

	}

	public ResponseDto(String action, String result, String message, Object values, HttpStatus status) {
		super();
		this.action = action;
		this.result = result;
		this.message = message;
		this.values = values;
		this.status = status;
	}

	@Override
	public String toString() {
		return "[action=" + action + "," + System.lineSeparator() + "result=" + result + "," + System.lineSeparator()
				+ " message=" + message + "," + System.lineSeparator() + " values=" + values.toString() + ","
				+ System.lineSeparator() + " status=" + status + "]";
	}

}
