package com.datarynx.jms;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerResource {
	
	Logger logger = LoggerFactory.getLogger(ProducerResource.class);
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private Queue queue;
	@GetMapping("/rest/{message}")
	public String publish(@PathVariable("message") final String message) {
		
		jmsTemplate.convertAndSend(queue,message);
		
		return "published successfully";
		
	}
	/*
	 * @GetMapping("/rest")
	 * 
	 * @JmsListener(destination = "standalone.queue") public void consume(String
	 * message) { logger.info("Received message "+message);
	 * System.out.println("Received message "+message); }
	 */

}
