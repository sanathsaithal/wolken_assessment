package com.wolken.mobile.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString

public class MobileDto {
	
	private String brandName;
	private String modelNo;
	private String modelName;
	private String type;
	private short ram;
	private short rom;
	private int price;
	private Boolean availability;
}
