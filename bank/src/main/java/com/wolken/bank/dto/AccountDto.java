package com.wolken.bank.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class AccountDto {
	private int accNo;
	private String accHolderName;
	private long contact;
	private String email;
	private String address;
	private String branchName;
	private String accType;
	private float amount;
	private boolean status;
	private String nominee;
	private String gender;
	private String dob;
}
