package com.dtechnoshop.dtechnoshopbackend.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtechnoshop.dtechnoshopbackend.dao.CartLineDAO;
import com.dtechnoshop.dtechnoshopbackend.dto.CartLineModel;
import com.dtechnoshop.dtechnoshopbackend.dto.CartModel;
import com.dtechnoshop.dtechnoshopbackend.service.CartLineService;

@Service("cartLineService")
public class CartLineServiceImpl implements CartLineService{

	@Autowired
	private CartLineDAO cartLineDAO;

	public boolean addCartLine(CartLineModel cartLine) {
		return cartLineDAO.addCartLine(cartLine);
	}

	public boolean updateCartLine(CartLineModel cartLine) {
		return cartLineDAO.updateCartLine(cartLine);
	}

	public boolean deleteCartLine(CartLineModel cartLine) {
		return cartLineDAO.deleteCartLine(cartLine);
	}

	public List<CartLineModel> getCartLine(int cartId) {
		return cartLineDAO.getCartLine(cartId);
	}

	public CartLineModel getSingleCartLine(int cartLineId) {
		return cartLineDAO.getSingleCartLine(cartLineId);
	}

	public List<CartLineModel> getAllCartLine() {
		return cartLineDAO.getAllCartLine();
	}

	public List<CartLineModel> getSearchedCartLine(int key) {
		return cartLineDAO.getSearchedCartLine(key);
	}

	public List<CartLineModel> getSpecificCartLine(String status) {
		return cartLineDAO.getSpecificCartLine(status);
	}
}
