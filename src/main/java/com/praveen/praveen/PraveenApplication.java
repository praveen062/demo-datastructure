package com.praveen.praveen;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


public class PraveenApplication {
	
	private static class Configuration extends AbstractApplicationConfiguration { }

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Configuration.class, args);
	}
}
