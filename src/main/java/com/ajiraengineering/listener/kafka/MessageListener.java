package com.ajiraengineering.listener.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
	
	@KafkaListener(topics = "${message.topic.name}", group = "messagegroup", containerFactory = "messageGroupKafkaListenerContainerFactory")
    public void listenGroupFoo(String message) {
        System.out.println("Received Messasge in group 'messagegroup': " + message);
	}

}
