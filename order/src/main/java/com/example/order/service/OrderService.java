package com.example.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.order.entity.OrderEntity;

@Service
public interface OrderService {
	public void createOrder(OrderEntity orderEntity);
	
	public Optional<OrderEntity> getOrderById(int orderId);
	
	public List<OrderEntity> getAllOrders();
	
	public OrderEntity updateOrder(OrderEntity orderEntity, int id);
	
	public List<OrderEntity> getByuserId(int userid);


	

	boolean updateLocation(String lat, String lon);
}
