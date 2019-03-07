package com.dtechnoshop.dtechnoshopfrontend.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dtechnoshop.dtechnoshopbackend.dto.UserLoginModel;
import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;
import com.dtechnoshop.dtechnoshopbackend.service.UserService;
import com.dtechnoshop.dtechnoshopbackend.serviceImpl.UserServiceImpl;

public class LoginEmailValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return UserModel.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		errors.rejectValue("email", null, "Email belum terdaftar !");
	}
}
