package com.dtechnoshop.dtechnoshopbackend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtechnoshop.dtechnoshopbackend.dao.DistributionDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.DistributionModel;
import com.dtechnoshop.dtechnoshopbackend.service.DistributionService;

@Service("distributionService")
public class DistributionServiceImpl implements DistributionService {

	@Autowired
	private DistributionDAO distributionDAO;
	
	public boolean addDistribution(DistributionModel distribution) {
		return distributionDAO.addDistribution(distribution);
	}

	public List<DistributionModel> getAllDistribution() {
		return distributionDAO.getAllDistribution();
	}
}
