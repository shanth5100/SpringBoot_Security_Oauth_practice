package com.me.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.me.dao.UserRepository;
import com.me.model.Oauth_User;

@Service(value = "userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Oauth_User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new BadCredentialsException("Bad credentials");
		}
//		 new AccountStatusUserDetailsChecker().check(user); 
		return user;
	}
}
