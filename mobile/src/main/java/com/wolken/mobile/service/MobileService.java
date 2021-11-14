package com.wolken.mobile.service;

import java.util.List;

import com.wolken.mobile.dto.MobileDto;
import com.wolken.mobile.entity.MobileEntity;

public interface MobileService {

	String save(MobileDto dto);

	List getByPrice(int price);

	List getByBrand(String bName);

	MobileEntity updatePrice(String modelNo, int price);

	MobileEntity updateAvailability(String modelName, Boolean availability);

}
