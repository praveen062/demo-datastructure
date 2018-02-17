package com.praveen.praveen.support;
import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;




@Configuration
public class WebXmlConfiguration {


    @Bean
    public ServletRegistrationBean jersey() {
    	
        Servlet jerseyServlet = new SpringServlet();
        ServletRegistrationBean jerseyServletRegistration = new ServletRegistrationBean();
        jerseyServletRegistration.setServlet(jerseyServlet);
        jerseyServletRegistration.addUrlMappings("/api/*");
        jerseyServletRegistration.setName("jersey-servlet");
        jerseyServletRegistration.setLoadOnStartup(1);
        jerseyServletRegistration.addInitParameter("com.sun.jersey.spi.container.ContainerResponseFilters",
                ResponseCorsFilter.class.getName());
        jerseyServletRegistration.addInitParameter(PackagesResourceConfig.PROPERTY_PACKAGES, "com.praveen.praveen");
        jerseyServletRegistration.addInitParameter("com.sun.jersey.config.feature.DisableWADL", "true");
        return jerseyServletRegistration;
    }
    
    
}
