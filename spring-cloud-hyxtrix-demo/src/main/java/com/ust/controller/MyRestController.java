package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.components.HelloImpl;

@RestController
public class MyRestController {
	
	@Autowired
	HelloImpl helloImpl;
	
	@RequestMapping("/getData")
	public String getData() {
		return helloImpl.getData();
	}
	
	@RequestMapping("/getAccounts")
	public ResponseEntity<String> getAccounts() {
		return helloImpl.getAccounts();
	}
}
