package com.wolken.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.EmployeeDto;
import com.wolken.bank.service.EmployeeService;

@RestController
public class EmployeeController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	EmployeeService service;
	@PostMapping("save")
	String save(@RequestBody EmployeeDto dto)
	{ 
		String message=null;
		try {
			message=service.validateAndSave(dto);
		} catch (Exception e) {
			logger.info(e.getMessage(), e.getClass().getSimpleName());
		}
		return message;
	}
	
	@GetMapping("getByDesignation")
	List<EmployeeDto> getByDesignation(@RequestParam String designation)
	{
		List<EmployeeDto> dto=null;
		try {
			dto=service.validateAndGetByDesignation(designation);
		} catch(Exception e) {
			logger.error(e.getMessage(),e.getClass().getName());
		}
		return dto;
	}
	
	@GetMapping("getBySalary")
	List<EmployeeDto> getBysalary(@RequestParam float salary)
	{
		List<EmployeeDto> dto=null;
		try {
			dto=service.validateAndGetBysalary(salary);
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getName());
		}
		return dto;
	}
	
	@GetMapping("getByName")
	List<EmployeeDto> getByName(@RequestParam String name)
	{
		List<EmployeeDto> dto=null;
		try {
			dto=service.validateAndGetByName(name);
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getClass().getName());
		}
		return dto;
	}
	
	@GetMapping("getAll")
	List<EmployeeDto> getAll()
	{
		List<EmployeeDto> dto=null;
		try {
			dto=service.validateAndGetAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getClass().getName());
		}
		return dto;
	}
	
	@PostMapping("saveAll")
	String saveAll(@RequestBody List<EmployeeDto> dto)
	{
		String message=null;
		try {
			message=service.validateAndSaveAll(dto);
		} catch (Exception e) {
			logger.error(e.getMessage(), e.getClass().getName());
		}
		return message;
	}
}
