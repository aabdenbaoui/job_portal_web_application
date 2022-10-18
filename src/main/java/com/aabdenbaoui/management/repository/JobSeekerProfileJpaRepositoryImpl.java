package com.aabdenbaoui.management.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.aabdenbaoui.management.dao.IJobSeekerProfileJpaRepository;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.EducationDetail;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.ExperienceDetail;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.SeekerProfile;

@Repository
public class JobSeekerProfileJpaRepositoryImpl {
	
	
	@Autowired
	IJobSeekerProfileJpaRepository jobSeekerProfileJpaRepository;	
	
	public void saveJobSeekerProfile(SeekerProfile seekerProfile) {
		jobSeekerProfileJpaRepository.save(seekerProfile);
	}

	public SeekerProfile findSeekerProfileById(long userId) {
		if(jobSeekerProfileJpaRepository.findById(userId) != null) {
			return jobSeekerProfileJpaRepository.findById(userId).get();
		}
		return null;		
	}
	
	public List<ExperienceDetail> getAllExperiencesBasedOnId(long id) {
        		return findSeekerProfileById(id).getExperiences();
	}
	
	public List<EducationDetail> getAllEducationsBasedOnId(long uSER_ID) {
 		   return findSeekerProfileById(uSER_ID).getEducations();
	}
	public boolean isExpererienceFound(long id) {
		
		return false;	
	}
	public List<SeekerProfile> getAllJobSeekers(){
		return jobSeekerProfileJpaRepository.getAllJobSeeker();
	}

	
}
