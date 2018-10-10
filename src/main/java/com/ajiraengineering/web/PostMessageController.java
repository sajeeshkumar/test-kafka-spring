package com.ajiraengineering.web;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ajiraengineering.service.kafka.MessageProducer;

@Controller
@RequestMapping("/message")
public class PostMessageController {
	
	@Autowired
	private MessageProducer messageProducer;
	
	@RequestMapping(method = RequestMethod.POST, value = "")
	public ResponseEntity<Void> createMessage(){
		
		Random random = new Random();
		messageProducer.sendMessage("test message" + random.nextInt());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
