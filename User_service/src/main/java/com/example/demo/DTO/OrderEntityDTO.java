package com.example.demo.DTO;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class OrderEntityDTO {
	
	private int orderId;

	private String productName;

	private Date orderOn;

	private String orderAddress;

	private int userId;

	private OrderdetailsDto orderdetails;

	@Override
	public String toString() {
		return "OrderEntityDTO [orderId=" + orderId + ", productName=" + productName + ", orderOn=" + orderOn
				+ ", orderAddress=" + orderAddress + ", userId=" + userId + ", orderdetails=" + orderdetails + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getOrderOn() {
		return orderOn;
	}

	public void setOrderOn(Date orderOn) {
		this.orderOn = orderOn;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public OrderdetailsDto getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(OrderdetailsDto orderdetails) {
		this.orderdetails = orderdetails;
	}

	public OrderEntityDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
