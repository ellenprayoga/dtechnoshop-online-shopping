package com.dtechnoshop.dtechnoshopbackend.service;

import com.dtechnoshop.dtechnoshopbackend.dto.CartModel;
import com.dtechnoshop.dtechnoshopbackend.dto.UserModel;

public interface CartService {
	// Add new cart
	public boolean addCart(CartModel cart);
		
	// Update cart
	public boolean update(CartModel cart);
		
	// Delete cart
	public boolean deleteCart(CartModel cart);
		
	// Get cart
	public CartModel getCart(UserModel user);
}
