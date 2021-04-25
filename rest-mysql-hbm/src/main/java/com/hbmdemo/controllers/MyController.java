package com.hbmdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyController {

	@GetMapping("/practice")
	public String sayHello() {
		return "Saying Hello : Akshay ";
	}
}
