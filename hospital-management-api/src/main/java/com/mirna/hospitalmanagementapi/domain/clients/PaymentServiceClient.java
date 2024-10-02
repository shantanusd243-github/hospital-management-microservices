package com.mirna.hospitalmanagementapi.domain.clients;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mirna.hospitalmanagementapi.domain.dtos.PaymentDTO;



@FeignClient(name="PAYMENT-SERVICE")
public interface PaymentServiceClient {
	
	  @PostMapping("/payment/api/create_order")
	  String createOrder(@RequestBody Map<String, Object> data);
	  
	  @PostMapping("/payment/api/payment")
	  ResponseEntity<?> createPayment(@RequestBody PaymentDTO payment);
	  
	  @PostMapping("/payment/api/mockPayment")
	  Object captureMockedPayment(@RequestBody Map<String, Object> data);
	  
}
