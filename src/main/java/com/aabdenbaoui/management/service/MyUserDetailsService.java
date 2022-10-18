package com.aabdenbaoui.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aabdenbaoui.management.entity.managingusers.User;
import com.aabdenbaoui.management.entity.managingusers.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UsersService userService;
//	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userService.findUserByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("Username was not found ");
		}
		
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
        UserDetails userDetails = new UserPrincipal(user);
//		return new UserPrincipal(user);
		System.out.println("Hashed password" + userDetails.getPassword());
		return userDetails;
	}

	
	 
}
