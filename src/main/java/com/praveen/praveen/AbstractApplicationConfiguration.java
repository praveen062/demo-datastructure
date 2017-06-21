package com.praveen.praveen;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.praveen.praveen.support.WebFrontEndConfiguration;
import com.praveen.praveen.support.WebXmlConfiguration;

@Configuration
@Import({ WebXmlConfiguration.class, WebFrontEndConfiguration.class})
@ComponentScan
@EnableAutoConfiguration(exclude = {
		FlywayAutoConfiguration.class,
		SecurityAutoConfiguration.class })
public abstract class AbstractApplicationConfiguration{

}
