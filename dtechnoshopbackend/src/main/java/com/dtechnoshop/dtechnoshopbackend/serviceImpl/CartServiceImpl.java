package com.dtechnoshop.dtechnoshopbackend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtechnoshop.dtechnoshopbackend.dao.CartDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.CartModel;
import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;
import com.dtechnoshop.dtechnoshopbackend.service.CartService;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;
	
	public boolean addCart(CartModel cart) {
		return cartDAO.addCart(cart);
	}

	public boolean update(CartModel cart) {
		return cartDAO.update(cart);
	}

	public boolean deleteCart(CartModel cart) {
		return cartDAO.deleteCart(cart);
	}

	public CartModel getCart(UserModel user) {
		return cartDAO.getCart(user);
	}

}
