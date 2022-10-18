package com.aabdenbaoui.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aabdenbaoui.management.entity.seekerprofilebuilder.SeekerProfile;
import com.aabdenbaoui.management.repository.JobSeekerProfileJpaRepositoryImpl;
@Service
public class RecruiterService {
	
	@Autowired
	JobSeekerProfileJpaRepositoryImpl jobSeekerProfileJpaRepositoryImpl;
	
	public List<SeekerProfile> getAllJobSeekers(){
		return jobSeekerProfileJpaRepositoryImpl.getAllJobSeekers();
	}

}
