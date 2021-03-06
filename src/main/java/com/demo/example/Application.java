package com.demo.example;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


public class Application {
	
	private static class Configuration extends AbstractApplicationConfiguration { }

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Configuration.class, args);
	}
}
