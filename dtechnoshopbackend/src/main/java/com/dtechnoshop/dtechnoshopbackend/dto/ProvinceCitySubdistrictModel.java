package com.dtechnoshop.dtechnoshopbackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "province_city_subdistrict")
public class ProvinceCitySubdistrictModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String province;
	private String city;
	private String subdistrict;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getSubdistrict() {
		return subdistrict;
	}
	
	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}
}
