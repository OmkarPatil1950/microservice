package com.example.order.entity;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.criteria.Order;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Orderdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderdetailsId;

	private String orderStatus;

	private int quantity;

	private int productPrice;

	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "order_id")
	private OrderEntity orders;

	public Orderdetails(int orderdetailsId, String orderStatus, int quantity, int productPrice, OrderEntity orders) {
		super();
		this.orderdetailsId = orderdetailsId;
		this.orderStatus = orderStatus;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.orders = orders;
	}



	public Orderdetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

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

	

	public OrderEntity getOrders() {
		return orders;
	}

	public void setOrders(OrderEntity orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Orderdetails [orderdetailsId=" + orderdetailsId + ", orderStatus=" + orderStatus + ", quantity="
				+ quantity + ", productPrice=" + productPrice + ", orders=" + orders + "]";
	}

}
