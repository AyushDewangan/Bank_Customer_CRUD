package com.example.demo.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.MyUser;
import com.example.demo.exception.UserAlredyExist;
import com.example.demo.model.MyUserModel;
import com.example.demo.repository.MyUserRepository;

@Service
public class MyUserModelImp implements MyUserService {

	@Autowired
	MyUserRepository myUserRepository;

	@Override
	public boolean save(@Validated MyUserModel myUserModel) {
		Optional<MyUser> myUserCheck = myUserRepository.findById(myUserModel.getId());
		if(Objects.nonNull(myUserCheck)) {
			//return throw new UserAlredyExist("bad credentials");
			return false;
		}
		MyUser myUser = new MyUser();
		//myUser.setId(myUserModel.getId());
		myUser.setName(myUserModel.getName());
		myUser.setPassword(myUserModel.getPassword());
		myUserRepository.save(myUser);
		return false;
	}

}
