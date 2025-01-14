package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.OrderEntityDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDetails;
import com.example.demo.service.userService;
import com.example.order.dto.LocationDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class userController {

	@Autowired
	private userService userservice;

	@GetMapping("/getall")
	public ResponseEntity<?> getAllUsers() {

		List<User> user = userservice.getAllUsers();
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody @Valid UserDTO userdto) {

		User savedUser = userservice.saveUser(userdto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body("User created successfully with userId: " + savedUser.getUserId());
	}

	@GetMapping("/OrderbyUserId")
	@CircuitBreaker(name = "user", fallbackMethod = "fallBackMethod")
	@TimeLimiter(name = "user")
	@Retry(name = "user")
	public CompletableFuture<ResponseEntity<?>> getOrderByUserId(@RequestParam int userId) {
	    return CompletableFuture.supplyAsync(() -> userservice.orderByUserId(userId)) // Async call to the service
	        .thenApply(user -> {
	            if (user == null || user.isEmpty()) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order is empty");
	            } else {
	                return ResponseEntity.status(HttpStatus.OK).body(user);
	            }
	        });
	}

	public CompletableFuture<ResponseEntity<?>> fallBackMethod(int userId, RuntimeException exception) {
	    System.out.println("Inside fallback method");
	    return CompletableFuture.supplyAsync(() -> ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
	            .body("Oops! Server is busy; please try after some time"));
	}
	
	
	///kafka 
	
//	@KafkaListener(topics = "order-topic", groupId = "7")
//	public void getLocation(LocationDto locationDto) {
//        System.out.println("Received Location: Latitude = " + locationDto.getLat() + ", Longitude = " + locationDto.getLon());
//	}
	


}
