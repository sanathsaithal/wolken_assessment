package com.wolken.mobile.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wolken.mobile.dao.MobileDao;
import com.wolken.mobile.dto.MobileDto;
import com.wolken.mobile.entity.MobileEntity;

@Component
public class MobileServiceImpl implements MobileService {
	Logger logger = Logger.getLogger(MobileServiceImpl.class);
	@Autowired
	MobileDao dao;

	public String save(MobileDto dto) {
		MobileEntity entity = new MobileEntity();

		if (!dto.getBrandName().equals(null) && !dto.getBrandName().equals("")) {
			if (!dto.getModelNo().equals(null) && !dto.getModelNo().equals("")) {
				if (!dto.getModelName().equals(null) && !dto.getModelName().equals("")) {
					if (!dto.getType().equals(null) && !dto.getType().equals("")) {
						if (dto.getRam() < 16) {
							if (dto.getRom() < 500) {
								if (dto.getPrice() < 99999) {
									if (!dto.getAvailability().equals(null) && !dto.getAvailability().equals("")) {

										BeanUtils.copyProperties(dto, entity);
										dao.save(entity);
									} else {
										logger.error("availability not added");
										return "availability not added";
									}
								} else {
									logger.error("price not added");
									return "price not added";
								}
							} else {
								logger.error("rom not added");
								return "rom not added";
							}
						} else {
							logger.error("ram not added");
							return "ram not added";
						}
					} else {
						logger.error("type not added");
						return "type not added";
					}
				} else {
					logger.error("model name not added");
					return "model name not added";
				}
			} else {
				logger.error("model no not added");
				return "model no not added";
			}
		} else {
			logger.error("brand name not added");
			return "brand name not added";
		}
		return null;
	}

	public List getByPrice(int price) {
		List list = null;
		if (price > 1000) {
			MobileEntity entity = new MobileEntity();
			list = dao.getByPrice(price);
		}
		return list;
	}

	public List getByBrand(String bName) {
		List list = null;
		if (!bName.equals(null) && !bName.equals("")) {
			MobileEntity entity = new MobileEntity();
			list = dao.getByBrand(bName);
		}
		return list;
	}

	public MobileEntity updatePrice(String modelNo, int price) {
		MobileEntity entity = new MobileEntity();
		if (!modelNo.equals(null) && !modelNo.equals("")) {
			if (price > 1000) {
				entity = dao.updatePriceByModelNo(modelNo, price);
			}
		}
		return entity;
	}

	public MobileEntity updateAvailability(String modelName, Boolean availability) {
		MobileEntity entity = new MobileEntity();
		if (!modelName.equals(null) && !modelName.equals("")) {
			if (availability != null) {
				entity = dao.updateAvailabilityByModelName(modelName, availability);
			}
		}
		return entity;
	}
}
