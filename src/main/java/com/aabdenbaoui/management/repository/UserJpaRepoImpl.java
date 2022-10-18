package com.aabdenbaoui.management.repository;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aabdenbaoui.management.dao.IUserJpaRepository;
import com.aabdenbaoui.management.entity.managingusers.User;

@Repository
@Transactional
public class UserJpaRepoImpl {
    
	@Autowired
	IUserJpaRepository userJpaRepository;

	public void saveUser(User user) {
		userJpaRepository.save(user);
	}
	public User findByUseByEmail(String email) {
		return userJpaRepository.findUserByEmail(email);
	}
	public List<User> findUsersByFirstName(String firstName){
		return userJpaRepository.findByFirstName(firstName);
	}
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return  userJpaRepository.findAll();
	}
	public User findUser(long id) {
		if(userJpaRepository.findById(id) != null) {
			return userJpaRepository.findById(id).get();
		}
		return null;		
	}



}
