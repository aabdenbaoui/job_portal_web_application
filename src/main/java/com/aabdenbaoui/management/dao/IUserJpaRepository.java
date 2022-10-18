package com.aabdenbaoui.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aabdenbaoui.management.entity.managingusers.User;


@Repository
public interface IUserJpaRepository extends JpaRepository<User, Long>{
	
//	public  void saveUser(User user);
    
	@Query("SELECT u from User u WHERE UPPER(TRIM(u.email))=UPPER(TRIM(:email)) ")
	public User findUserByEmail(@Param("email") String email);
	public List<User> findByFirstName(String firstName);
	public List<User> findByLastName(String lastName);
	public List<User> findByFirstNameAndLastName(String firstName, String lastName);
   
	

}
