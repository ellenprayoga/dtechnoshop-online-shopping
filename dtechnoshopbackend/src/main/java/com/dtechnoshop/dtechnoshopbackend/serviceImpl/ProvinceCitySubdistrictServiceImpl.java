package com.dtechnoshop.dtechnoshopbackend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtechnoshop.dtechnoshopbackend.dao.ProvinceCitySubdistrictDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.ProvinceCitySubdistrictModel;
import com.dtechnoshop.dtechnoshopbackend.service.ProvinceCitySubdistrictService;

@Service("provinceCitySubdistrictService")
public class ProvinceCitySubdistrictServiceImpl implements ProvinceCitySubdistrictService {

	@Autowired
	private ProvinceCitySubdistrictDAO provinceCitySubdistrictDAO;
	
	public boolean addProvinceCitySubdistrict(ProvinceCitySubdistrictModel model) {
		return provinceCitySubdistrictDAO.addProvinceCitySubdistrict(model);
	}

	public boolean updateProvinceCitySubdistrict(ProvinceCitySubdistrictModel model) {
		return provinceCitySubdistrictDAO.updateProvinceCitySubdistrict(model);
	}

	public boolean deleteProvinceCitySubdistrict(ProvinceCitySubdistrictModel model) {
		return provinceCitySubdistrictDAO.deleteProvinceCitySubdistrict(model);
	}

	public List<ProvinceCitySubdistrictModel> getProvinceCitySubdistrict() {
		return provinceCitySubdistrictDAO.getProvinceCitySubdistrict();
	}

	public List<String> getAllProvince() {
		return provinceCitySubdistrictDAO.getAllProvince();
	}

	public List<String> getAllCity(String province) {
		return provinceCitySubdistrictDAO.getAllCity(province);
	}

	public List<String> getAllSubdistrict(String city) {
		return provinceCitySubdistrictDAO.getAllSubdistrict(city);
	}

}
