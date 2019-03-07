package com.dtechnoshop.dtechnoshopbackend.dao;

import java.util.List;

import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;

public interface UserDAO {
	// Add new user
	public boolean addUser(UserModel user);
	
	// Update user
	public boolean updateUser(UserModel user);
	
	// Delete user
	public boolean deleteUser(UserModel user);
	
	// Get single user
	public UserModel getSingleUser(int id);
	
	// Get all users
	public List<UserModel> getAllUser();
	
	// Get user login
	public UserModel getUserLogin(String email);
	
	// Get searched user
	public List<UserModel> getSearchedUser(int userId); 
}