package com.eureka.main.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EureController {
	
	@RequestMapping("/server")
	public String serverCode() {
		return "This is Eureka server";
	}

}
