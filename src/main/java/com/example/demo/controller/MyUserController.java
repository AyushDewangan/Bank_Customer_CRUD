package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MyUserModel;
import com.example.demo.service.MyUserService;

@RestController
@RequestMapping("/user")
public class MyUserController {
	
	private final MyUserService myUserService;
	public MyUserController(MyUserService myUserService) {
		this.myUserService = myUserService;
	}
	
	@PostMapping
	public ResponseEntity<Boolean> saveUser(@PathVariable MyUserModel myUserModel) {
		return ResponseEntity.ok().body(myUserService.save(myUserModel));
	}
}
