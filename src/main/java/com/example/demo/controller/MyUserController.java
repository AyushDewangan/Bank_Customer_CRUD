package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MyUserModel;
import com.example.demo.service.MyUserService;

@RestController
@RequestMapping("/user")
public class MyUserController {
	final MyUserService userService;

	public MyUserController(MyUserService userService) {
		this.userService = userService;
	}

	@PostMapping
	private ResponseEntity<Boolean> createUser(@Valid @RequestBody MyUserModel myUserModel) {
		return ResponseEntity.ok().body(userService.save(myUserModel));
	}

}