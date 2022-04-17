package com.olx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginServiceDelegateImpl implements LoginServiceDelegate{
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public boolean isTokenValid(String authToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", authToken);
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Boolean> response = 
				this.restTemplate.exchange("http://localhost:9092/olx/login/token/validate", HttpMethod.GET, entity, Boolean.class);
		return response.getBody();
	}

}
