package edu.tcd.tapserve;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApp {
	private static final Logger logger = LoggerFactory.getLogger(StartApp.class);

	public static void main(String[] args) {
		logger.debug("Staring spring boot configuration.");
		SpringApplication.run(StartApp.class, args);
	}
}
