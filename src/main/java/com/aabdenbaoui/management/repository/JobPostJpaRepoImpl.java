package com.aabdenbaoui.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aabdenbaoui.management.dao.IJobPostJpaRepository;
import com.aabdenbaoui.management.entity.jobpost.JobPost;

@Repository
public class JobPostJpaRepoImpl {
	
	@Autowired
	IJobPostJpaRepository jobPostJpaRepository;
	
	public void saveNewJobPost(JobPost jobPost) {
		jobPostJpaRepository.save(jobPost);
		
	}
   
	public List<JobPost> getAllJobPosts(){
		return jobPostJpaRepository.findAll();
	}
	
	public void deleteJobPostById(long id) {
	   jobPostJpaRepository.deleteById(id);;
	}

	public void disableJobPost(Long jobPostid) {
	     Optional<JobPost> jobPostOptional= jobPostJpaRepository.findById(jobPostid);
	     JobPost jobPostTem;
	     if(jobPostOptional.isPresent()) {
	          jobPostTem = jobPostOptional.get();
	          jobPostTem.setIsActive(false);
	    	 jobPostJpaRepository.save(jobPostTem);
	     }
		
	}

	public void enableJobPost(Long jobPostid) {
		//get Optional Yupe Job Post
		 Optional<JobPost> jobPostOptional= jobPostJpaRepository.findById(jobPostid);
	     JobPost jobPostTem;
	     //check if present and pass it to Temp Job Post
	     if(jobPostOptional.isPresent()) {
	          jobPostTem = jobPostOptional.get();
	          //set isActive to true 
	          jobPostTem.setIsActive(true);
	          //pass back the Job Post to be saved at the database
	    	 jobPostJpaRepository.save(jobPostTem);
	     }
		
	}
}
