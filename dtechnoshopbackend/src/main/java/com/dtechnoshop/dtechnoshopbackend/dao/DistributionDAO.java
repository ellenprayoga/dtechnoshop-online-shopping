package com.dtechnoshop.dtechnoshopbackend.dao;

import java.util.List;

import com.dtechnoshop.dtechnoshopbackend.dto.DistributionModel;

public interface DistributionDAO {
	// Add new distribution
	public boolean addDistribution(DistributionModel distribution);
	
	// Get all distribution
	public List<DistributionModel> getAllDistribution();
}
