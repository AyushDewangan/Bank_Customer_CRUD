package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyRole;
import com.example.demo.entity.MyUser;
import com.example.demo.model.MyUserModel;
import com.example.demo.repository.MyRoleRepository;
import com.example.demo.repository.MyUserRepository;

@Service
public class MyUserModelImp implements MyUserService {

	@Autowired
	private MyRoleRepository myRoleRepository;

	private final MyUserRepository myUserRepository;
	private final PasswordEncoder passwordEncoder;

	public MyUserModelImp(MyUserRepository myUserRepository, PasswordEncoder passwordEncoder) {
		super();
		this.myUserRepository = myUserRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public boolean save(MyUserModel myUserModel) {
		MyUser user = new MyUser();
		user.setId(myUserModel.getId());
		user.setName(myUserModel.getName());
		user.setPassword(passwordEncoder.encode(myUserModel.getPassword()));
		List<MyRole> role1 = new ArrayList<>();
		myUserModel.getRoleModel().stream().forEach(rM -> {
			Optional<MyRole> role = myRoleRepository.findByRole(rM.getRole());
			if (!role.isPresent()) {
				MyRole myRole = new MyRole();
				myRole.setRole(rM.getRole());
				myRole.setRoleId(rM.getRoleId());
				role1.add(myRole);
			} else {
				MyRole r = role.get();
				role1.add(r);
			}

		});
		user.setRole(role1);
		try {
			myUserRepository.save(user);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
