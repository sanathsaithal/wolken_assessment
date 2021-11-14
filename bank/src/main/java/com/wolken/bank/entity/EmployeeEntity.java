package com.wolken.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
@ToString

public class EmployeeEntity {
	@Id
	@GenericGenerator(name="sanath", strategy="increment")
	@GeneratedValue(generator="sanath")
	private int id;
	private String name;
	private String designation;
	private String email;
	private long contact;
	private float salary;
}
