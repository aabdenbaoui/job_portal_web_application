package com.aabdenbaoui.management.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aabdenbaoui.management.entity.jobpost.JobPost;
import com.aabdenbaoui.management.repository.JobPostJpaRepoImpl;

@Service
public class JobPostService {
  
	  @Autowired
	  JobPostJpaRepoImpl jobPostJpaRepoImpl;
	  
	  public void createNewJobPos(JobPost jobPost) {
		  jobPostJpaRepoImpl.saveNewJobPost(jobPost);		  
	  }
	 
	  public List<JobPost> getAllActiveJobPosts(){
		  return jobPostJpaRepoImpl.getAllJobPosts().stream().filter(s->s.getIsActive()).collect(Collectors.toList());
	  }

	public void deleteJobPostService(Long jobPostid) {
		   jobPostJpaRepoImpl.deleteJobPostById(jobPostid);
	}

	public void disableJobPostService(Long jobPostid) {
		jobPostJpaRepoImpl.disableJobPost(jobPostid);
	}
	  public List<JobPost> getAllDisabledJobPosts(){
		  return jobPostJpaRepoImpl.getAllJobPosts().stream().filter(s->!s.getIsActive()).collect(Collectors.toList());
	  }

	public void enableJobPostService(Long jobPostid) {
		jobPostJpaRepoImpl.enableJobPost(jobPostid);
	}
	
}
