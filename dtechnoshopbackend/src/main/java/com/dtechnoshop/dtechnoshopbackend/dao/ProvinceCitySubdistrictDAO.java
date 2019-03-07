package com.dtechnoshop.dtechnoshopbackend.dao;

import java.util.List;

import com.dtechnoshop.dtechnoshopbackend.dto.ProvinceCitySubdistrictModel;

public interface ProvinceCitySubdistrictDAO {
	// Add new province, city and subdistrict
	public boolean addProvinceCitySubdistrict(ProvinceCitySubdistrictModel model);
	
	// Update province, city and subdistrict
	public boolean updateProvinceCitySubdistrict(ProvinceCitySubdistrictModel model);
	
	// Delete province, city and subdistrict
	public boolean deleteProvinceCitySubdistrict(ProvinceCitySubdistrictModel model);
	
	// Get all provinces, cities and subdistricts
	public List<ProvinceCitySubdistrictModel> getProvinceCitySubdistrict();
	
	// Get all provinces
	public List<String> getAllProvince();
	
	// Get all cities
	public List<String> getAllCity(String province);
	
	// Get all subdistricts
	public List<String> getAllSubdistrict(String city);
}
