package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.OrderEntityDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.serviceImplimentation.userServiceImpl;

@Service
public interface userService {

	public List<User> getAllUsers();

	public User saveUser(UserDTO user);
	
	public String login(String username, String password); 
	
	public List<OrderEntityDTO> orderByUserId(int userId);
}
