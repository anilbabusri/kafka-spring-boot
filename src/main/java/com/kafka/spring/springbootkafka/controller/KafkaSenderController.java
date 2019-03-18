package com.kafka.spring.springbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.spring.springbootkafka.model.User;
import com.kafka.spring.springbootkafka.service.Producer;



@RestController
@EnableKafka
public class KafkaSenderController {
	
	@Autowired
	private Producer producer;

	@PostMapping("/send")
	public void sendMessage(@RequestBody User user) {
		producer.send(user);
	}
	
	@GetMapping("/healthcheck")
	public String healthCheck() {
		return "Success";
	}
}
