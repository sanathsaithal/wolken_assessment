package com.wolken.mobile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table
@ToString
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
	@NamedQuery(name="getByBrandName" ,query = "from MobileEntity where brandName=:name"),
	@NamedQuery(name="getByPrice" ,query = "from MobileEntity where price<=:price"),
	@NamedQuery(name="updatePrice" ,query = "update MobileEntity set price=:price where modelNo=:modelNo "),
	@NamedQuery(name="updateAvailability" ,query = "update MobileEntity set availability=:availability where modelName=:modelName ")
})

public class MobileEntity {
	@Id
	@GenericGenerator( name ="sam", strategy="increment")
	@GeneratedValue(generator="sam", strategy=GenerationType.IDENTITY)
	@Column
	private int id;
	@Column
	private String brandName;
	@Column
	private String modelNo;
	@Column
	private String modelName;
	@Column
	private String type;
	@Column
	private short ram;
	@Column
	private short rom;
	@Column
	private int price;
	@Column
	private Boolean availability;

}
