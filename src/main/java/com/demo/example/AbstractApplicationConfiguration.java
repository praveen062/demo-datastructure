package com.demo.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.demo.example.support.WebFrontEndConfiguration;
import com.demo.example.support.WebXmlConfiguration;

@Configuration
@Import({ WebXmlConfiguration.class, WebFrontEndConfiguration.class})
@ComponentScan
@EnableAutoConfiguration(exclude = {
		FlywayAutoConfiguration.class,
		SecurityAutoConfiguration.class })
public abstract class AbstractApplicationConfiguration{

}
