package com.aabdenbaoui.management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.aabdenbaoui.management.entity.managingusers.User;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.SeekerProfile;

public interface IJobSeekerProfileJpaRepository extends JpaRepository<SeekerProfile, Long>{
//    @Modifying
//    @Transactional
//	@Query("DELETE  FROM SeekerProfile WHERE experienceDetailId = 1")
//	public void deleteExperienceById(long id);
	
	@Query("SELECT u from SeekerProfile u ")
	public List<SeekerProfile> getAllJobSeeker();
}
