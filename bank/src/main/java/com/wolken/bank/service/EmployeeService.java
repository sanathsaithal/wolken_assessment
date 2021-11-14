package com.wolken.bank.service;

import java.util.List;

import com.wolken.bank.dto.EmployeeDto;

public interface EmployeeService {

	String validateAndSave(EmployeeDto dto);

	List<EmployeeDto> validateAndGetByDesignation(String designation);

	List<EmployeeDto> validateAndGetBysalary(float salary);

	List<EmployeeDto> validateAndGetByName(String name);

	List<EmployeeDto> validateAndGetAll();

	String validateAndSaveAll(List<EmployeeDto> dto);

}
