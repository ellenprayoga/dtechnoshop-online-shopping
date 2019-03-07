package com.dtechnoshop.dtechnoshopbackend.service;

import java.util.List;

import com.dtechnoshop.dtechnoshopbackend.dto.DistributionModel;

public interface DistributionService {
	// Add new distribution
	public boolean addDistribution(DistributionModel distribution);

	// Get all distribution
	public List<DistributionModel> getAllDistribution();
}
