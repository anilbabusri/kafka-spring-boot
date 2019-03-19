package com.kafka.spring.springbootkafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.kafka.spring.springbootkafka.model.User;


@Service
public class Producer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Value("${kafka.topic.name}")
	private String kafkaTopic;
	
	public void send(User user) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(kafkaTopic, user.toString());

	    // you can register a callback with the listener to receive the result
	    // of the send asynchronously
	    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	      @Override
	      public void onSuccess(SendResult<String, String> result) {
	    	  System.out.println(user+"  has been pushed to kafka");
	      }

	      @Override
	      public void onFailure(Throwable ex) {
	        System.out.println("unable to send message="+ user.toString()+"   "+ ex);
	      }
	    });

	}

}
