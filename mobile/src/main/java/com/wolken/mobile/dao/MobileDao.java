package com.wolken.mobile.dao;

import java.util.List;

import com.wolken.mobile.entity.MobileEntity;

public interface MobileDao {

	String save(MobileEntity entity);

	List getByBrand(String bName);

	List getByPrice(int price);

	MobileEntity updateAvailabilityByModelName(String modelName, Boolean availability);

	MobileEntity updatePriceByModelNo(String modelNo, int price);

}
