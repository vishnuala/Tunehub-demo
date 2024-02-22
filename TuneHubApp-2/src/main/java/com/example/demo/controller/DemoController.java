package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.FormData;

@CrossOrigin("*")
@RestController
public class DemoController {
	@GetMapping("/testGet")
	public String testGet() {
		System.out.println("Call received");
		return"call received";
	}
	
	@PostMapping("/testPost")
	public String testPost(@RequestBody String data) {
		System.out.println("Post Request Received : "+data);
		return"Post Request Received : "+data;
	}
	
	@PostMapping("/testForm")
	public String testForm(@RequestBody String formdata) {
		System.out.println("Form data Received : "+formdata);
		return"Post Request Received : "+formdata;
	}
	
	@PostMapping("/formData")
	public String formData(@RequestBody FormData data) {
		System.out.println("Form data Received : "+data);
		return"Post Request Received : "+data;
	}

}
