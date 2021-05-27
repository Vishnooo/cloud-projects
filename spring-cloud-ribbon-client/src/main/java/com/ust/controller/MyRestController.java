package com.ust.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;

@RestController
public class MyRestController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/client/frontend/")
	public String frontend() {
		URI uri = URI.create("http://productserver/productBackend");
		String response = this.restTemplate.getForObject(uri, String.class);
		return "Server response : " + response;
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}	
}
