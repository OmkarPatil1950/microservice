package com.example.order.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.order.dto.LocationDto;
import com.example.order.entity.OrderEntity;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrderService;
import com.netflix.discovery.converters.Auto;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	
	

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
//
	@Autowired
    private KafkaTemplate<String, LocationDto> kafkaTemplate; // Update the value type

//	@Autowired
//    private KafkaTemplate<String, String> kafkaTemplateString; // Update the value type

	@Override
	public void createOrder(OrderEntity orderEntity) {
		// TODO Auto-generated method stub

//		OrderEntity neworderEntity = modelMapper.map(orderEntity, OrderEntity.class);

		orderRepository.save(orderEntity);

	}

	@Override
	public Optional<OrderEntity> getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId);
	}

	@Override
	public List<OrderEntity> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderEntity updateOrder(OrderEntity orderEntity, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderEntity> getByuserId(int userid) {
		// TODO Auto-generated method stub
		List<OrderEntity> orderentity = orderRepository.findByUserId(userid);
		return orderentity;
	}

	@Override
	public boolean updateLocation(String lat,String lon) {
		// TODO Auto-generated method stub
	    LocationDto location = new LocationDto(lat, lon);
	    
	   /// if you want to pass more than one arg to the send method excpet topic-name , then you need to send as dto or json
		System.out.println("inside kafka service");
//		kafkaTemplateString.send("order-topic","120");
		kafkaTemplate.send("order-topic",location);
		return true;
	}

}
