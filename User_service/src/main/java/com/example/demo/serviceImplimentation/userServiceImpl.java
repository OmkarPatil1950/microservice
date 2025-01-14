package com.example.demo.serviceImplimentation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.DTO.OrderEntityDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.config.WebClientConfig;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDetails;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.userService;

@Service
public class userServiceImpl implements userService {

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private WebClient.Builder webclient;
	
	@Autowired
	private PasswordEncoder password;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	@Override
	public User saveUser(UserDTO userdto) {
		// TODO Auto-generated method stub
		User user = mapToEntity(userdto);
		return userrepository.save(user);
	}
	
	private User mapToEntity(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setContact(userDTO.getContact());
		user.setPassword(password.encode(userDTO.getPassword()));
		UserDetails userDetails = new UserDetails();
		userDetails.setGender(userDTO.getUserdetails().getGender());
		userDetails.setAge(userDTO.getUserdetails().getAge());
		userDetails.setAddress(userDTO.getUserdetails().getAddress());
		userDetails.setPincode(userDTO.getUserdetails().getPincode());

		user.setUserdetails(userDetails);
		userDetails.setUsers(user);
		// Map other fields as needed
		return user;
	}

	@Override
	public List<OrderEntityDTO> orderByUserId(int userId) {
	    return Arrays.asList(webclient.build()
	        .get()
	        .uri("http://ORDER/api/order/userId?userId={userId}", userId)///ORDERSERVICE is name represent in disco
	        .retrieve()
	        .bodyToMono(OrderEntityDTO[].class)  // Expecting an array of OrderEntityDTO
	        .block());  // Blocking to return a list
	}
	
	/// loadbalncer does not work with hard core url like localhost:8082

	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
