package com.datarynx.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	Logger logger = LoggerFactory.getLogger(Consumer.class);

	@JmsListener(destination = "standalone.queue")
	public void consume(String message) {
		logger.info("Received message "+message);
		System.out.println("Received message "+message);
	}
}
