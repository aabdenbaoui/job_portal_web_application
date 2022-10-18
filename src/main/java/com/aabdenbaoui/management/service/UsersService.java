package com.aabdenbaoui.management.service;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aabdenbaoui.management.entity.enums.UserTypeEnum;
import com.aabdenbaoui.management.entity.managingusers.User;
import com.aabdenbaoui.management.repository.UserJpaRepoImpl;

@Service
public class UsersService{
	
	@Autowired
	UserJpaRepoImpl userRepo;
    
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private long userId;
	 
	private UserTypeEnum userTypeEnum;

	public void saveUser(User user) {
	

	
        String encodedPassword = passwordEncoder.encode(user.getPassword());
	    userRepo.saveUser(new User(capitalisaltion(user.getFirstName()), capitalisaltion(user.getLastName()), encodedPassword,user.getEmail(), user.getAccountType()));
	  	 
	}
	
	public User createUserWithHasshedPassword(User user) {
		
        String encodedPassword = passwordEncoder.encode(user.getPassword());


	   return new User(capitalisaltion(user.getFirstName()), capitalisaltion(user.getLastName()), encodedPassword,user.getEmail(), user.getAccountType());
	}
	private String  capitalisaltion(String name) {
		return  name.substring(0, 1).toUpperCase() + name.substring(1);
	}
	


	public boolean isFound(String email) {
            if(userRepo.findByUseByEmail(email) != null) {
            	return true;
            }
       		return false;
	}
	
	public User findUserByEmail(String email) throws UsernameNotFoundException {
		User tempUser = userRepo.findByUseByEmail(email);
		System.out.print("Inside userService is " + tempUser);
		if(tempUser == null) {
			System.out.println("Username was not found");
			throw new UsernameNotFoundException("Username was not found ");
			
		}
        if( tempUser != null) {
        	userId = tempUser.getUserId();
    		userTypeEnum = tempUser.getAccountType().getUserType();
        }
		return tempUser;
	}

	public UserTypeEnum getUserType() {
		return userTypeEnum;
	}
	public long getUserId() {
		return userId;
	}

}
