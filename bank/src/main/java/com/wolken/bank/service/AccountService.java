package com.wolken.bank.service;

import java.util.List;

import com.wolken.bank.dto.AccountDto;

public interface AccountService {

	String validateAndSave(AccountDto dto);

	String validateAndGetBalanceByName(String name);

	List<AccountDto> validateAndGetAccountByBranchName(String branchName);

	List<AccountDto> validateAndGetAllAccount();

	String validateAndDepsoit(int accNo, float amount);

	String validateAndWithdraw(int accNo, float amount);

	String validateAndUpdateStatus(int accNo);

	

}
