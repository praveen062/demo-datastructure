package com.praveen.praveen;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.praveen.praveen.support.AbstractApplicationConfiguration;
import com.praveen.praveen.support.EmbeddedTomcatWithSSLConfiguration;

public class PraveenApplication {
	
	private static class Configuration extends AbstractApplicationConfiguration { }

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Configuration.class, args);
	}
}
