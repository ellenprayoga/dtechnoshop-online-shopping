package com.dtechnoshop.dtechnoshopbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "cart")
@DynamicUpdate
public class CartModel {
	@Id
	private int id;
	
	@Column(name = "grand_total")
	private double grandTotal;
	
	@Column(name = "cart_lines")
	private int cartLines;
	
	@OneToOne
	private UserModel user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getCartLines() {
		return cartLines;
	}

	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	
	

	/*public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}*/
}
