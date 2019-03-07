package com.dtechnoshop.dtechnoshopbackend.service;

import java.util.List;

import com.dtechnoshop.dtechnoshopbackend.dto.CartLineModel;
import com.dtechnoshop.dtechnoshopbackend.dto.CartModel;

public interface CartLineService {
	// Add new cart line
	public boolean addCartLine(CartLineModel cartLine);

	// Update cart
	public boolean updateCartLine(CartLineModel cartLine);

	// Delete cart
	public boolean deleteCartLine(CartLineModel cartLine);

	// Get single cart line
	public CartLineModel getSingleCartLine(int cartLineId);

	// Get cart line
	public List<CartLineModel> getCartLine(int cartId);

	// Get all cart line
	public List<CartLineModel> getAllCartLine();

	// Get all cart line with specific status
	public List<CartLineModel> getSpecificCartLine(String status);

	// Get searched cart line
	public List<CartLineModel> getSearchedCartLine(int key);
}
