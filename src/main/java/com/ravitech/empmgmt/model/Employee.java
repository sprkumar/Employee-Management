package com.ravitech.empmgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ravindra
 *
 */
@Entity
@Table(name = "employee")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer age;
	private String email;
	private String mobileNo;
	private String address;
	private Double salary;

}
