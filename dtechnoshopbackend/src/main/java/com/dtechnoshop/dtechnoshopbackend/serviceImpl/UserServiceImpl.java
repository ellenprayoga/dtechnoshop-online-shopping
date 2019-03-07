package com.dtechnoshop.dtechnoshopbackend.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtechnoshop.dtechnoshopbackend.dao.UserDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;
import com.dtechnoshop.dtechnoshopbackend.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	public boolean addUser(UserModel user) {
		return userDAO.addUser(user);
	}

	public boolean updateUser(UserModel user) {
		return userDAO.updateUser(user);
	}

	public boolean deleteUser(UserModel user) {
		return userDAO.deleteUser(user);
	}

	public UserModel getSingleUser(int id) {
		return userDAO.getSingleUser(id);
	}

	public List<UserModel> getAllUser() {
		return userDAO.getAllUser();
	}

	public UserModel getUserLogin(String email) {
		return userDAO.getUserLogin(email);
	}

	public List<UserModel> getSearchedUser(int userId) {
		return userDAO.getSearchedUser(userId);
	}
}
