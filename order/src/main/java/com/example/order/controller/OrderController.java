package com.example.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.entity.OrderEntity;
import com.example.order.service.OrderService;

import jakarta.persistence.criteria.Order;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
		// TODO Auto-generated constructor stub
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveOrder(@RequestBody @Valid OrderEntity orderEntity) {
		System.out.println("Inside order save");
		orderService.createOrder(orderEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body("Order placed successfully");
	}

	@GetMapping("/byId")
	public ResponseEntity<?> getById(@RequestParam(required = false) int id) {
		System.out.println("inside get order by id");
		Optional<OrderEntity> order = orderService.getOrderById(id);
		if (order.isPresent()) {
			return ResponseEntity.ok(order.get()); // Return the order with a 200 OK status
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found"); // Return 404 with a message
		}

	}

	@GetMapping("/userId")
	public ResponseEntity<?> getByUserId(@RequestParam int userId) {

		System.out.println("---------------inside order by userId-----------------" + userId);
//		try {
////			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("-----Exception----");
		List<OrderEntity> order = orderService.getByuserId(userId);
		if (order != null) {
			System.out.println("Inside if ---------" + order);
			return ResponseEntity.status(HttpStatus.OK).body(order);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order with user id " + userId + " not found");
	}

	@PostMapping("/update-location")
	public ResponseEntity<?> updateLocation(@RequestParam String lat,@RequestParam String lon) {
		boolean isLocation = orderService.updateLocation(lat,lon);
		return ResponseEntity.status(HttpStatus.OK).body("updated");
	}

}
