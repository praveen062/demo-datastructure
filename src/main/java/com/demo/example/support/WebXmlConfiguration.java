package com.demo.example.support;
import java.util.List;

import javax.servlet.Servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;




@Configuration
public class WebXmlConfiguration extends WebMvcConfigurationSupport  {


    @Bean
    public ServletRegistrationBean jersey() {
    	
        Servlet jerseyServlet = new SpringServlet();
        ServletRegistrationBean jerseyServletRegistration = new ServletRegistrationBean();
        jerseyServletRegistration.setServlet(jerseyServlet);
        jerseyServletRegistration.addUrlMappings("/api/*");
        jerseyServletRegistration.setName("jersey-servlet");
        jerseyServletRegistration.setLoadOnStartup(1);
        jerseyServletRegistration.addInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
        jerseyServletRegistration.addInitParameter("com.sun.jersey.spi.container.ContainerResponseFilters",
                ResponseCorsFilter.class.getName());
        jerseyServletRegistration.addInitParameter(PackagesResourceConfig.PROPERTY_PACKAGES, "com.praveen.praveen");
        jerseyServletRegistration.addInitParameter("com.sun.jersey.config.feature.DisableWADL", "true");

        return jerseyServletRegistration;
    }
    
    
    @Bean
    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
     MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
     ObjectMapper objectMapper = new ObjectMapper();
     objectMapper.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
     objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
     objectMapper.setSerializationInclusion(Include.NON_NULL);
     jsonConverter.setObjectMapper(objectMapper);
     return jsonConverter;
    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
     converters.add(customJackson2HttpMessageConverter());
    }
    
}
