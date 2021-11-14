package com.wolken.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.wolken.bank.entity.AccountEntity;

public interface AccountRepo extends JpaRepositoryImplementation<AccountEntity, Integer>{
	AccountEntity getAmountByAccHolderName(String name);
	List<AccountEntity> getAccountByBranchName(String branchName);
	AccountEntity getByAccNo(int accNo);
}
