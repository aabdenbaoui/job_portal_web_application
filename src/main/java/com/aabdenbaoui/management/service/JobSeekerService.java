package com.aabdenbaoui.management.service;

import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aabdenbaoui.management.entity.enums.Major;
import com.aabdenbaoui.management.entity.enums.UserTypeEnum;
import com.aabdenbaoui.management.entity.jobpost.JobPost;
import com.aabdenbaoui.management.entity.managingusers.User;
import com.aabdenbaoui.management.entity.managingusers.UserDetail;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.EducationDetail;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.ExperienceCompany;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.ExperienceDetail;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.SeekerProfile;
import com.aabdenbaoui.management.repository.JobSeekerProfileJpaRepositoryImpl;
import com.aabdenbaoui.management.repository.UserJpaRepoImpl;

@Service
public class JobSeekerService {

	@Autowired
	UserJpaRepoImpl userRepo;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	JobSeekerProfileJpaRepositoryImpl jobSeekerProfileJpaRepositoryImpl;
	
	@Autowired
	JobPostService jobPostService;



	
	public User findUserByEmailService(String email) {
		return userRepo.findByUseByEmail(email);
	}
	public List<User> findUsersByFirstName(String firstName){
		 return getAllActiveJobSeekers().stream().filter(s -> (s.getFirstName().toLowerCase().equals(firstName))).collect(Collectors.toList());
	}
	public List<User> findUsersByLastName(String lastName){
		 return getAllActiveJobSeekers().stream().filter(s -> (s.getLastName().toLowerCase().equals(lastName))).collect(Collectors.toList());
	}
	public List<User> findUserByCity(String city) {
		return getAllActiveJobSeekers().stream().filter(s -> (s.getFirstName().toLowerCase().equals(city))).collect(Collectors.toList());
	}
	public List<User> findUserByZipCode(String zipCode) {
		return getAllActiveJobSeekers().stream().filter(s -> (s.getFirstName().toLowerCase().equals(zipCode))).collect(Collectors.toList());
	}
	public List<User> getAllActiveJobSeekers() {
	     return userRepo.getAllUsers().stream().filter(s -> (s.getAccountType().getUserType() == UserTypeEnum.JOB_SEEKER )).collect(Collectors.toList());
	}
	public List<User> getAllRecruiters(){
	    return userRepo.getAllUsers().stream().filter(s -> (s.getAccountType().getUserType() == UserTypeEnum.HR_PERSONAL)).collect(Collectors.toList());
	}
	
	
	public void saveUserDetails(UserDetail userDetail) {
        User user = userRepo.findUser(usersService.getUserId());
        System.out.print("user for details: " + user);
        user.setUserDetail(userDetail);
        userRepo.saveUser(user);
	}
	
	public void createJobSeekerProfile(SeekerProfile seekerProfile) {
		jobSeekerProfileJpaRepositoryImpl.saveJobSeekerProfile(seekerProfile);		
	}
	
	public List<ExperienceDetail> getAllExperiences() {
		System.out.println("Job Seeker  user id: " + jobSeekerProfileJpaRepositoryImpl.findSeekerProfileById(usersService.getUserId()));
		System.out.println(jobSeekerProfileJpaRepositoryImpl.getAllExperiencesBasedOnId(usersService.getUserId()));
		return jobSeekerProfileJpaRepositoryImpl.getAllExperiencesBasedOnId(usersService.getUserId());
	}
	
	public List<EducationDetail> getAllEducations() {
		return jobSeekerProfileJpaRepositoryImpl.getAllEducationsBasedOnId(usersService.getUserId());
		
	}
	public void saveExperience(ExperienceDetail experience) {
        SeekerProfile seekerProfile = jobSeekerProfileJpaRepositoryImpl.findSeekerProfileById(usersService.getUserId());
        experience.setSeekerProfile(seekerProfile);
        List<ExperienceDetail> experiencesById = seekerProfile.getExperiences().stream().filter(s -> (s.getExperienceDetailId() == experience.getExperienceDetailId())).collect(Collectors.toList());
		 if(seekerProfile.getExperiences().size() != 0 && experiencesById.size() != 0) {
             ExperienceDetail	experienceTemp  = experiencesById.get(0);
             experienceTemp.setExperienceDetailId(experience.getExperienceDetailId());
             experienceTemp.setTimeLine(experience.getTimeLine());
             experienceTemp.setSalary(experience.getSalary());
             experienceTemp.setCurrentJob(experience.isCurrentJob());
             experienceTemp.setJobTitle(experience.getJobTitle());
             experienceTemp.setExperienceCompany(experience.getExperienceCompany());
             experienceTemp.setWorkExperienceDescription(experience.getWorkExperienceDescription());
             seekerProfile.getExperiences().add(experienceTemp);
             deleteExperience(experience.getExperienceDetailId());
          }else{
        	  seekerProfile.getExperiences().add(experience);
     		 jobSeekerProfileJpaRepositoryImpl.saveJobSeekerProfile(seekerProfile);
          }
	}
	public void saveEducation(EducationDetail education) {
            SeekerProfile seekerProfile = jobSeekerProfileJpaRepositoryImpl.findSeekerProfileById(usersService.getUserId());
            education.setSeekerProfile(seekerProfile);
            List<EducationDetail> educationsById = seekerProfile.getEducations().stream().filter(s -> (s.getEducationDetailId() == education.getEducationDetailId())).collect(Collectors.toList());
             if(seekerProfile.getEducations().size() != 0 && educationsById.size() != 0) {
	                EducationDetail	educationTemp  = educationsById.get(0);
	                educationTemp.setEducationDetailId(education.getEducationDetailId());
	                educationTemp.setTimeLine(education.getTimeLine());
	                educationTemp.setCertificateDegreeName(education.getCertificateDegreeName());
	                educationTemp.setMajor(education.getMajor());
	                educationTemp.setUniversity_name(education.getUniversity_name());
	                educationTemp.setCumulativeGpa(education.getCumulativeGpa());
	                seekerProfile.getEducations().add(educationTemp);
	                deleteEducation(education.getEducationDetailId());       
             }else{
            	 seekerProfile.getEducations().add(education);
          		 jobSeekerProfileJpaRepositoryImpl.saveJobSeekerProfile(seekerProfile);
             }
	}
	
	public void deleteExperience(Long experienceID) {
        SeekerProfile seekerProfile = jobSeekerProfileJpaRepositoryImpl.findSeekerProfileById(usersService.getUserId());
         seekerProfile.getExperiences().remove(seekerProfile.getExperiences().stream().filter(s -> (s.getExperienceDetailId() == experienceID)).collect(Collectors.toList()).get(0));
		 jobSeekerProfileJpaRepositoryImpl.saveJobSeekerProfile(seekerProfile);
	}
	public void deleteEducation(Long educationId) {
		 SeekerProfile seekerProfile = jobSeekerProfileJpaRepositoryImpl.findSeekerProfileById(usersService.getUserId());
         seekerProfile.getEducations().remove(seekerProfile.getEducations().stream().filter(s -> (s.getEducationDetailId() == educationId)).collect(Collectors.toList()).get(0));
		 jobSeekerProfileJpaRepositoryImpl.saveJobSeekerProfile(seekerProfile);

	}
	public EducationDetail getEducationDetail(long educationId) {
        SeekerProfile seekerProfile = jobSeekerProfileJpaRepositoryImpl.findSeekerProfileById(usersService.getUserId() );
		return seekerProfile.getEducations().stream().filter(s -> (s.getEducationDetailId() == educationId)).collect(Collectors.toList()).get(0);	
	}
	public ExperienceDetail getExperienceDetail(Long experienceID) {
		    SeekerProfile seekerProfile = jobSeekerProfileJpaRepositoryImpl.findSeekerProfileById(usersService.getUserId() );
			return seekerProfile.getExperiences().stream().filter(s -> (s.getExperienceDetailId() == experienceID)).collect(Collectors.toList()).get(0);	
	}
	public void saveJobPost(Long jobpostId) {
        SeekerProfile seekerProfile = jobSeekerProfileJpaRepositoryImpl.findSeekerProfileById(usersService.getUserId());
        List<JobPost> jobPostsById = jobPostService.getAllActiveJobPosts().stream().filter(s -> (s.getJobPostId() == jobpostId)).collect(Collectors.toList());
        System.out.println("Job Posts size" + jobPostsById.size());
        for(JobPost jobPost : jobPostsById) {
        	System.out.println(jobPost);
        }
        if( jobPostsById.size() != 0) {
        	JobPost tempJobPost = jobPostsById.get(0);
        	seekerProfile.getJobPosts().add(tempJobPost);
    		jobSeekerProfileJpaRepositoryImpl.saveJobSeekerProfile(seekerProfile);
            System.out.println("Saved");

        }  
	}
	

	
}
