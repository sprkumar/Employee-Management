package com.ravitech.empmgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
	@Id
	@Column(name="address_id")
	private Long addressId;
	private String lane1;
	private String city;
	private String state;
	private String country;
	private Long pincode;
}
