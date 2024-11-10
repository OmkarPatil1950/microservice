package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class OrderdetailsDto {
	private int orderdetailsId;

	private String orderStatus;

	private int quantity;

	private int productPrice;

	private OrderEntityDTO orders;

	public int getOrderdetailsId() {
		return orderdetailsId;
	}

	public void setOrderdetailsId(int orderdetailsId) {
		this.orderdetailsId = orderdetailsId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public OrderEntityDTO getOrders() {
		return orders;
	}

	public void setOrders(OrderEntityDTO orders) {
		this.orders = orders;
	}

	public OrderdetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
