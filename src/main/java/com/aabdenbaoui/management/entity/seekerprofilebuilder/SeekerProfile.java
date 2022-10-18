package com.aabdenbaoui.management.entity.seekerprofilebuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.aabdenbaoui.management.entity.jobpost.JobPost;
import com.aabdenbaoui.management.entity.managingusers.User;

@Entity
@Table(name = "seeker_profile")
public class SeekerProfile {

	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "seeker_profile_id_pk")
	 private long seekerProfileId;
	 
	 private String firstName;
	 
	 private String lastName;
	 
	 private long annualSalary;
   
	 
	 @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER)
     @JoinColumn(name = "user_id_fk")
	 private User userAccount;
	 

	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<ExperienceDetail> experiences = new ArrayList<>();
	 
	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<EducationDetail> educations = new ArrayList<>();
	 
	 
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JoinColumn(name = "seeker_skill_id_fk")
	 private SeekerSkill seekerSkill;

	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<JobPost> jobPosts = new ArrayList<>();
	 
	public SeekerProfile() {
    }

	public SeekerProfile(String firstName, String lastName, User userAccount) {
		this.firstName = firstName;
		this.lastName = lastName;
	    this.userAccount = userAccount;
	}

	public SeekerProfile(String firstName2, String lastName2) {
		this.firstName = firstName2;
		this.lastName = lastName2;
	}

	public List<ExperienceDetail> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<ExperienceDetail> experienceDetails) {
		this.experiences = experienceDetails;
	}
	public long getSeekerProfileId() {
		return seekerProfileId;
	}

	public void setSeekerProfileId(long seekerProfileId) {
		this.seekerProfileId = seekerProfileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(long annualSalary) {
		this.annualSalary = annualSalary;
	}

	public User getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(User userAccount) {
		this.userAccount = userAccount;
	}

	public List<EducationDetail> getEducations() {
		return educations;
	}

	public void setEducations(List<EducationDetail> educations) {
		this.educations = educations;
	}

	public List<JobPost> getJobPosts() {
		return jobPosts;
	}

	public void setJobPosts(List<JobPost> jobPosts) {
		this.jobPosts = jobPosts;
	}

	
}
