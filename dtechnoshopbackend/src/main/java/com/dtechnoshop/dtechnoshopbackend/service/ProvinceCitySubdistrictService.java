package com.dtechnoshop.dtechnoshopbackend.service;

import java.util.List;

import com.dtechnoshop.dtechnoshopbackend.dto.ProvinceCitySubdistrictModel;

public interface ProvinceCitySubdistrictService {
	// Add new province, city and subdistrict
	public boolean addProvinceCitySubdistrict(ProvinceCitySubdistrictModel model);

	// Update province, city and subdistrict
	public boolean updateProvinceCitySubdistrict(ProvinceCitySubdistrictModel model);

	// Delete province, city and subdistrict
	public boolean deleteProvinceCitySubdistrict(ProvinceCitySubdistrictModel model);

	// Get all province, city and subdistrict
	public List<ProvinceCitySubdistrictModel> getProvinceCitySubdistrict();

	// Get all province
	public List<String> getAllProvince();

	// Get all city
	public List<String> getAllCity(String province);

	// Get all subdistrict
	public List<String> getAllSubdistrict(String city);
}
