package com.ust.components;

import org.springframework.stereotype.Component;

@Component
public class MyBackendService {

	public String getData() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "This message is from the backend service of the same project";
	}
}
