package com.example.order.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;

	@NotBlank(message = "Product name cannot be blank")
	@Size(max = 255, message = "Product name cannot exceed 255 characters")
	private String productName;

	@NotNull(message = "Order date cannot be null")
	@PastOrPresent(message = "Order date cannot be in the future")
//	@Pattern(regexp = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$",message = "Order date should be in format yyyy-mm-dd")
	private Date orderOn;

	@NotBlank(message = "Order address cannot be blank")
	@Size(max = 500, message = "Order address cannot exceed 500 characters")
	private String orderAddress;

	@NotNull(message = "User ID cannot be null")
	private int userId;

	@OneToOne(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Orderdetails orderdetails;

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
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

	public Orderdetails getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(Orderdetails orderdetails) {
		this.orderdetails = orderdetails;
	}

	
	public OrderEntity(int orderId, String productName, Date orderOn, String orderAddress, int userId,
			Orderdetails orderdetails) {
		super();
		this.orderId = orderId;
		this.productName = productName;
		this.orderOn = orderOn;
		this.orderAddress = orderAddress;
		this.userId = userId;
		this.orderdetails = orderdetails;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", productName=" + productName + ", orderOn=" + orderOn
				+ ", orderAddress=" + orderAddress + ", userId=" + userId + "]";
	}

}
