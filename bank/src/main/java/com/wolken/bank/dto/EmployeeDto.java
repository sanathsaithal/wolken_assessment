package com.wolken.bank.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class EmployeeDto {
	private int id;
	private String name;
	private String designation;
	private String email;
	private long contact;
	private float salary;
}
