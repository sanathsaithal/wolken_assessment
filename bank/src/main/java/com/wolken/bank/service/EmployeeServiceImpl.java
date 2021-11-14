package com.wolken.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.introspector.BeanAccess;

import com.wolken.bank.dto.EmployeeDto;
import com.wolken.bank.entity.AccountEntity;
import com.wolken.bank.entity.EmployeeEntity;
import com.wolken.bank.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EmployeeRepo repo;

	@Override
	public String validateAndSave(EmployeeDto dto) {
		try {
			if (!dto.getName().equals(null) && !dto.getName().equals("")) {
				if (!dto.getDesignation().equals(null) && !dto.getDesignation().equals("")) {
					if (!dto.getEmail().equals(null) && !dto.getEmail().equals("")) {
						if (dto.getContact() >= 5999999999l && dto.getContact() < 9999999999l) {
							if (dto.getSalary() > 0) {

								EmployeeEntity entity = new EmployeeEntity();
								BeanUtils.copyProperties(dto, entity);
								repo.save(entity);
								logger.info("" + entity);
								return "Account created";
							} else {
								logger.error("Please add salary");
								return "Please add salary";
							}
						} else {
							logger.error("Please enter contact no");
							return "Please enter contact no";
						}
					} else {
						logger.error("Please provide email address");
						return "Please provide email address";
					}
				} else {
					logger.error("Please enter designation");
					return "Please enter designation";
				}
			} else {
				logger.error("Please enter name");
				return "Please enter name";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getClass().getName());
		}
		return null;
	}

	@Override
	public List<EmployeeDto> validateAndGetByDesignation(String designation) {
		List<EmployeeDto> lDto = new ArrayList<>();
		List<EmployeeEntity> entity = repo.getByDesignation(designation);
		try {
			logger.info("" + entity);
			for (EmployeeEntity employeeEntity : entity) {
				EmployeeDto dto = new EmployeeDto();
				BeanUtils.copyProperties(employeeEntity, dto);
				lDto.add(dto);
				logger.info("" + lDto);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getClass().getName());
		}

		return lDto;
	}

	@Override
	public List<EmployeeDto> validateAndGetBysalary(float salary) {
		List<EmployeeDto> lDto = new ArrayList<>();
		List<EmployeeEntity> entity = repo.getBySalary(salary);
		try {
			logger.info("" + entity);
			for (EmployeeEntity employeeEntity : entity) {
				EmployeeDto dto = new EmployeeDto();
				BeanUtils.copyProperties(employeeEntity, dto);
				lDto.add(dto);
				logger.info("" + lDto);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getClass().getName());
		}
		return lDto;
	}

	@Override
	public List<EmployeeDto> validateAndGetByName(String name) {
		List<EmployeeDto> lDto = new ArrayList<>();
		List<EmployeeEntity> entity = repo.getByName(name);
		try {
			logger.info("" + entity);
			for (EmployeeEntity employeeEntity : entity) {
				EmployeeDto dto = new EmployeeDto();
				BeanUtils.copyProperties(employeeEntity, dto);
				lDto.add(dto);
				logger.info("" + lDto);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getClass().getName());
		}
		return lDto;
	}

	@Override
	public List<EmployeeDto> validateAndGetAll() {
		List<EmployeeDto> lDto = new ArrayList<>();
		List<EmployeeEntity> entity = repo.findAll();
		try {
			logger.info("" + entity);
			for (EmployeeEntity employeeEntity : entity) {
				EmployeeDto dto = new EmployeeDto();
				BeanUtils.copyProperties(employeeEntity, dto);
				lDto.add(dto);
				logger.info("" + lDto);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getClass().getName());
		}
		return lDto;
	}

	@Override
	public String validateAndSaveAll(List<EmployeeDto> eDto) {
		try {
			if (eDto != null) {
				for (EmployeeDto dto : eDto) {
					if (!dto.getName().equals(null) && !dto.getName().equals("")) {
						if (!dto.getEmail().equals(null) && !dto.getEmail().equals("")) {
							if (!dto.getDesignation().equals(null) && !dto.getDesignation().equals("")) {
								if (dto.getContact() > 5999999999l && dto.getContact() < 9999999999l) {
									if (dto.getSalary() > 1000) {
										EmployeeEntity entity = new EmployeeEntity();
										List<EmployeeEntity> list = new ArrayList<>();
										BeanUtils.copyProperties(dto, entity);
										list.add(entity);
										repo.saveAll(list);
										logger.info("Account created");
										return "Account created";
									} else {
										logger.info("invalid salary");
										return "Invalid salary";
									}
								} else {
									logger.info("invalid contact number");
									return "Invalid contact number";
								}
							} else {
								logger.info("invalid designation");
								return "Invalid designation";
							}
						} else {
							logger.info("invalid email");
							return "Invalid email";
						}
					} else {
						logger.info("invalid name");
						return "Invalid name";
					}
				}

			} else {
				logger.info("Object is null");
				return "Object is null";
			}
		} catch (Exception e) {
			logger.info(e.getMessage(), e.getClass().getSimpleName());
		}
		return null;

	}

}
