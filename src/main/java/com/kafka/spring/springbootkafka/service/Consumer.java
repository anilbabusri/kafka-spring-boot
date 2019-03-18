package com.kafka.spring.springbootkafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class Consumer {

	@KafkaListener(topics="oyo", groupId="group-id")
	public void cosume(String message) {
		System.out.println(message);
	}
	
}
