package com.example.demo.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyUser;
import com.example.demo.exception.UserNotExist;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.MyUserRepository;

@Service
public class MyAuthManager implements AuthenticationManager {

	private final MyUserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public MyAuthManager(MyUserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getPrincipal().toString();

		MyUser user = userRepository.findByName(userName)
				.orElseThrow(() -> new UserNotExist("User doesn't exit with userName : " + userName));
		String password = authentication.getCredentials().toString();
		if (!passwordEncoder.matches(password, user.getPassword())) {
			throw new UserNotFoundException("User Not Found");
		}

		MyUserAuthentication myUserAuthentication = new MyUserAuthentication(userName, password);
		myUserAuthentication.setAuthenticated(true);
		return myUserAuthentication;
	}

}