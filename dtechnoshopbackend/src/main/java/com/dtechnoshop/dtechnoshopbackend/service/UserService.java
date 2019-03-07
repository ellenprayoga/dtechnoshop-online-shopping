package com.dtechnoshop.dtechnoshopbackend.service;

import java.util.List;

import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;

public interface UserService {
	// Add new user
	public boolean addUser(UserModel user);

	// Update user
	public boolean updateUser(UserModel user);

	// Delete user
	public boolean deleteUser(UserModel user);

	// Get single user
	public UserModel getSingleUser(int id);

	// Get all user
	public List<UserModel> getAllUser();
	
	// Get user login
	public UserModel getUserLogin(String email);
	
	// Get searched user
	public List<UserModel> getSearchedUser(int userId);
}
