package com.wolken.bank.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.bank.dto.AccountDto;
import com.wolken.bank.entity.AccountEntity;
import com.wolken.bank.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	AccountRepo repo;
	SimpleDateFormat dob=new SimpleDateFormat("dd/MM/yyyy");
	@Override
	public String validateAndSave(AccountDto dto) {
		try {
			if (!dto.getAccHolderName().equals(null) && !dto.getAccHolderName().equals("")) {
				if (dto.getContact() >= 5999999999l && dto.getContact() < 9999999999l) {
					if (!dto.getEmail().equals(null) && !dto.getEmail().equals("")) {
						if (!dto.getAddress().equals(null) && !dto.getAddress().equals("")) {
							if (!dto.getBranchName().equals(null) && !dto.getBranchName().equals("")) {
								if (!dto.getAccType().equals(null) && !dto.getAccType().equals("")) {
									if (dto.getAmount() > 0) {
										if (!dto.getNominee().equals(null) && !dto.getNominee().equals("")) {
											if (!dto.getGender().equals(null) && !dto.getGender().equals("")) {
												if (!dto.getDob().equals(null) && !dto.getDob().equals("")) {
													AccountEntity entity = new AccountEntity();
													Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDob());
													entity.setDob(date1);
													BeanUtils.copyProperties(dto, entity);
													repo.save(entity);
													logger.info("" + entity);
													return "data saved";
												} else {
													logger.error("Date of dirth not added");
													return "Date of dirth not added";
												}
											} else {
												logger.error("Gender should have some values");
												return "Gender should have some values";
											}
										} else {
											logger.error("Nominee not added");
											return "Nominee not added";
										}
									} else {
										logger.error("Amount should have some values");
										return "Amount should have some values";
									}
								} else {
									logger.error("Account type should have some values");
									return "Account type should have some values";
								}
							} else {
								logger.error("Branch name should not be null");
								return "ram not added";
							}
						} else {
							logger.error("Address not addes");
							return "Address not added";
						}
					} else {
						logger.error("Email id should not be null");
						return "Email id should not be null";
					}
				} else {
					logger.error("Contact no not proper");
					return "Contact no not proper";
				}
			} else {
				logger.error("Account holder name should not be null");
				return "Account holder name should not be null";
			}
		} catch (Exception e) {
			logger.info(e.getMessage(), e.getClass().getName());
		}
		return null;
	}

	@Override
	public String validateAndGetBalanceByName(String name) {
		AccountDto dto = new AccountDto();
		AccountEntity entity = repo.getAmountByAccHolderName(name);
		try {
			logger.info("" + entity);
				BeanUtils.copyProperties(entity, dto);
				dto.setDob(dob.format(entity.getDob()));
				logger.info("" + dto);
				return ""+dto.getAmount();
			
		} catch (Exception e) {
			logger.info(e.getMessage(), e.getClass().getName());
		}
		return null;
	}

	@Override
	public List<AccountDto> validateAndGetAccountByBranchName(String branchName) {
		List<AccountDto> lDto = new ArrayList<>();
		List<AccountEntity> entity = repo.getAccountByBranchName(branchName);
		try {
			logger.info("" + entity);
			for (AccountEntity accountEntity : entity) {
				AccountDto dto = new AccountDto();
				BeanUtils.copyProperties(accountEntity, dto);
				dto.setDob(dob.format(accountEntity.getDob()));
				lDto.add(dto);
				logger.info("" + lDto);
			}
		} catch (Exception e) {
			logger.info(e.getMessage(), e.getClass().getName());
		}
		return lDto;
	}

	@Override
	public List<AccountDto> validateAndGetAllAccount() {
		List<AccountDto> lDto = new ArrayList<>();
		List<AccountEntity> entity = repo.findAll();
		try {
			logger.info("" + entity);
			for (AccountEntity accountEntity : entity) {
				AccountDto dto = new AccountDto();
				BeanUtils.copyProperties(accountEntity, dto);
				lDto.add(dto);
				logger.info("" + lDto);
			}
		} catch (Exception e) {
			logger.info(e.getMessage(), e.getClass().getName());
		}
		return lDto;
	}

	@Override
	public String validateAndDepsoit(int accNo, float amount) {
		try {
			if (!Objects.isNull(accNo)) {
				AccountEntity entity = repo.getByAccNo(accNo);
				if (entity != null) {
					if (amount > 0) {
						entity.setAmount(entity.getAmount() + amount);
						repo.save(entity);
						logger.info("" + entity);
						return "Amount credited to your account, current balance is: " + entity.getAmount();
					} else {
						logger.info("Please enter amount");
						return "Please enter amount";
					}
				} else {
					logger.info("Account not found for this account number");
					return "Account not found for this account number";
				}
			} else {
				logger.info("Please enter account number");
				return "Please enter account number";
			}
		} catch (Exception e) {
			logger.info(e.getMessage(), e.getClass().getName());
		}
		return null;
	}

	@Override
	public String validateAndWithdraw(int accNo, float amount) {
		try {
			if (!Objects.isNull(accNo)) {
				AccountEntity entity = repo.getByAccNo(accNo);
				if (entity != null) {
					if (amount > 0) {
						if (amount < entity.getAmount() ) {
							entity.setAmount(entity.getAmount() - amount);
							repo.save(entity);
							logger.info("" + entity);
							logger.info("Amount credited to your account, current balance is: " + entity.getAmount());
							return "Amount credited to your account, current balance is: " + entity.getAmount();
						} else {
							logger.info("Your current balance is less than what you entered, Your current balance is"
									+ entity.getAmount());
							return "Your current balance is less than what you entered, Your current balance is"
									+ entity.getAmount();
						}
					} else {
						logger.info("Please enter amount");
						return "Please enter amount";
					}
				} else {
					logger.info("Account not found for this account number");
					return "Account not found for this account number";
				}
			} else {
				logger.info("Please enter account number");
				return "Please enter account number";
			}
		} catch (Exception e) {
			logger.info(e.getMessage(), e.getClass().getName());
		}
		return null;
	}

	@Override
	public String validateAndUpdateStatus(int accNo) {
		try {
			AccountEntity entity = repo.getByAccNo(accNo);
			if (entity != null) {
				entity.setStatus(false);
				repo.save(entity);
				return "Account is currently suspended for your account number";
			} else {
				logger.info("Account not found");
				return "Account not found";
			}
		} catch (Exception e) {
			logger.info(e.getMessage(), e.getClass().getName());
		}
		return null;
	}

}
