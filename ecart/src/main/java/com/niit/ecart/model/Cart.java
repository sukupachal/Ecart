package com.niit.ecart.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Cart implements Serializable {
	@Id
	@GeneratedValue
	private int CartId;
	public int getCartId() {
		return CartId;
	}
	public void setCartId(int cartId) {
		CartId = cartId;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getCarttotal() {
		return carttotal;
	}
	public void setCarttotal(double carttotal) {
		this.carttotal = carttotal;
	}
	public String getCartStatus() {
		return cartStatus;
	}
	public void setCartStatus(String cartStatus) {
		this.cartStatus = cartStatus;
	}
	@OneToMany(mappedBy="cart")
	private List<CartItem> cartItems;
	private double carttotal;
	private String cartStatus;

}
