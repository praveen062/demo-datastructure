package com.demo.example.support;

import java.util.Map;

import com.sun.jersey.api.core.ResourceConfig;



public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
           
       }

	@Override
	public Map<String, Boolean> getFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getFeature(String featureName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}
   }
