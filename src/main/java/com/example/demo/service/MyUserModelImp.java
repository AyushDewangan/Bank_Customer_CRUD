package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.MyRole;
import com.example.demo.entity.MyUser;
import com.example.demo.model.MyUserModel;
import com.example.demo.repository.MyUserRepository;

@Service
public class MyUserModelImp implements MyUserService {

	private final MyUserRepository myUserRepository;
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
		List<MyRole> role = new ArrayList<>();
		myUserModel.getRoleModel().stream().forEach(rm -> {
			MyRole myRole = new MyRole();
			myRole.setRole(rm.getRole());
			myRole.setRoleId(rm.getRoleId());
			role.add(myRole);
		});
		myUser.setRole(role);
		try {
			myUserRepository.save(myUser);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
