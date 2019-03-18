package com.kafka.spring.springbootkafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/kafka")
public class TestController {

	@GetMapping("/send")
	public String send() {
		return "hello";
	}
}
