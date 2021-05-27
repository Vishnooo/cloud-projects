package com.ust.components;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class HelloImpl {

	@Autowired
	MyBackendService backendService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallback_1")
	public String getData() {
		return backendService.getData();
	}
	
	@HystrixCommand(fallbackMethod = "fallback_2")
	public ResponseEntity<String> getAccounts(){
		URI uri =  URI.create("http://localhost:9090/getDataFromCloud");
		return restTemplate.getForEntity(uri, String.class);
	}
	
	public String fallback_1() {
		return "Either internal server is down or not accessible right now.";
	}
	
	public ResponseEntity<String> fallback_2() {
		return new ResponseEntity<String>("Either external server is down or not accessible right now.", HttpStatus.OK);
	}
}
