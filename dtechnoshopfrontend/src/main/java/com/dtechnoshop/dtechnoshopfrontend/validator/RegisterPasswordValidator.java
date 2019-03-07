package com.dtechnoshop.dtechnoshopfrontend.validator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;
import com.dtechnoshop.dtechnoshopbackend.service.UserService;
import com.dtechnoshop.dtechnoshopbackend.serviceImpl.UserServiceImpl;

public class RegisterPasswordValidator implements Validator {
	private UserService userService;
	private AnnotationConfigApplicationContext context;

	public boolean supports(Class<?> clazz) {
		return UserModel.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		UserModel userModel = (UserModel) target;
		
		if (!userModel.getPassword().equals(userModel.getValidatePassword())) {
			errors.rejectValue("validatePassword", null, "Password tidak sama !");
			return;
		}
	}

}
