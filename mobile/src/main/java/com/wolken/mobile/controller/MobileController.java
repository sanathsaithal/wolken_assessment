package com.wolken.mobile.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wolken.mobile.dto.MobileDto;
import com.wolken.mobile.entity.MobileEntity;
import com.wolken.mobile.service.MobileService;


@Controller
public class MobileController {
	
	Logger logger=Logger.getLogger(MobileController.class);
	
	@Autowired
	MobileService service;
	@RequestMapping(value="insert", method= RequestMethod.POST)

	ModelAndView saveDetails(MobileDto dto)
	{
		ModelAndView view = new ModelAndView();
		logger.info(dto);
		MobileEntity entity=new MobileEntity();
		service.save(dto);
		view.setViewName("response");
		view.addObject("msg", "The Details you enteed is successfully saved and can be viewed for further references");
		view.addObject("data", dto);
		
		return view;
		
	}
	@RequestMapping("save")
	ModelAndView save() {
		ModelAndView view=new ModelAndView();
		view.setViewName("InsertMobDetails");
		return view;
	}
	@RequestMapping("getByPrice")
	ModelAndView getbyPrice() {
		ModelAndView view=new ModelAndView();
		view.setViewName("GetByPrice");
		return view;
	}
	@RequestMapping("byPrice")
	ModelAndView filterByPrice(MobileDto dto) {
		ModelAndView view=new ModelAndView("display");
		List list=service.getByPrice(dto.getPrice());
		logger.info(list);
		view.addObject("list", list);
		return view;
	}
	
	@RequestMapping("getByBrand")
	ModelAndView getByBrand() {
		ModelAndView view=new ModelAndView();
		view.setViewName("GetByBrand");
		return view;
	}
	@RequestMapping("byBrand")
	ModelAndView getByBrand(MobileDto dto) {
		ModelAndView view=new ModelAndView("display");
		List list=service.getByBrand(dto.getBrandName());
		logger.info(list);
		view.addObject("list", list);
		return view;
	}
	
	@RequestMapping("index")
	ModelAndView homePage() {
		ModelAndView view=new ModelAndView();
		view.setViewName("index");
		return view;
	}
	
	@RequestMapping("updatePriceByModelNo")
	ModelAndView updatePrice() {
		ModelAndView view=new ModelAndView();
		view.setViewName("UpdatePriceByModelNo");
		return view;
	}
	@RequestMapping("updatePriceByModel")
	ModelAndView updatePrice(MobileDto dto) {
		ModelAndView view=new ModelAndView("index");
		MobileEntity entity=service.updatePrice(dto.getModelNo(),dto.getPrice());
		logger.info(entity);
		view.addObject("list", entity);
		return view;
	}
	
	@RequestMapping("updateAvailabilityByModel")
	ModelAndView updateAvailability() {
		ModelAndView view=new ModelAndView();
		view.setViewName("UpdateAvailabilityByName");
		return view;
	}
	@RequestMapping("updateAvailabilityByModelName")
	ModelAndView updateAvailability(MobileDto dto) {
		ModelAndView view=new ModelAndView("index");
		MobileEntity entity=service.updateAvailability(dto.getModelName(),dto.getAvailability());
		logger.info(entity);
		view.addObject("list", entity);
		return view;
	}
	
	@RequestMapping("home")
	ModelAndView home() {
		ModelAndView view=new ModelAndView();
		view.setViewName("index");
		return view;
	}
	
	
}


