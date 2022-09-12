package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.MyUser;
import com.example.demo.model.MyUserModel;
import com.example.demo.repository.MyUserRepository;

@Service
public class MyUserModelImp implements MyUserService {

	private final MyUserRepository myUserRepository;
	@SuppressWarnings("unused")
	private final PasswordEncoder passwordEncoder;

	public MyUserModelImp(MyUserRepository myUserRepository, PasswordEncoder passwordEncoder) {
		super();
		this.myUserRepository = myUserRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public boolean save(@Validated MyUserModel myUserModel) {
		MyUser myUser = new MyUser();
		myUser.setId(myUserModel.getId());
		myUser.setName(myUserModel.getName());
		myUser.setPassword(passwordEncoder.encode(myUserModel.getPassword()));
		try {
			myUserRepository.save(myUser);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
