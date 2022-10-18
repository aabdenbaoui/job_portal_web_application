package com.aabdenbaoui.management.entity.jobpost;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.aabdenbaoui.management.entity.company.Company;
import com.aabdenbaoui.management.entity.managingusers.User;

@Entity
@Table(name = "job_post")
public class JobPost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "job_post_id_pk")
	private long jobPostId;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "job_details_id_fk")
	private JobDetails jobDetails;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id_fk")
	private Company company;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "posted_by_id_fk")
	private User userPostedJob;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "job_post_activity_id_fk")
	private JobPostActivity jobPostActivity;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "job_post_skill_set_id_fk")
	private JobPostSkillSet jobPostSkillSet;	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "job_location_id_fk")
	private JobLocation jobLocation;
	
	@Column(name = "job_description")
	private String jobDescription;
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "job_position_name")
	private String jobPositionName;
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private List<JobBenefit> jobBenefits;
	
	@CreationTimestamp
	@Column(name = "created_date")
	private LocalDate dateCreated;
	   	   
	   @PrePersist
	   void createdAt() {
		   	this.dateCreated = LocalDate.now();
	   }
	   
	
	public JobPost() {
	}
	public long getJobPostId() {
		return jobPostId;
	}
	public void setJobPostId(long jobPostId) {
		this.jobPostId = jobPostId;
	}
	
	public JobDetails getJobDetails() {
		return jobDetails;
	}

	public void setJobDetails(JobDetails jobDetails) {
		this.jobDetails = jobDetails;
	}

	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public User getUserPostedJob() {
		return userPostedJob;
	}
	public void setUserPostedJob(User userPostedJob) {
		this.userPostedJob = userPostedJob;
	}
	public JobPostActivity getJobPostActivity() {
		return jobPostActivity;
	}
	public void setJobPostActivity(JobPostActivity jobPostActivity) {
		this.jobPostActivity = jobPostActivity;
	}
	public JobPostSkillSet getJobPostSkillSet() {
		return jobPostSkillSet;
	}
	public void setJobPostSkillSet(JobPostSkillSet jobPostSkillSet) {
		this.jobPostSkillSet = jobPostSkillSet;
	}
	public JobLocation getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(JobLocation jobLocation) {
		this.jobLocation = jobLocation;
	}
	
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getJobPositionName() {
		return jobPositionName;
	}
	public void setJobPositionName(String jobPositionName) {
		this.jobPositionName = jobPositionName;
	}
	
	
	public LocalDate getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}


	@Override
	public String toString() {
		return "JobPost [jobPostId=" + jobPostId + ", jobDetails=" + jobDetails + ", company=" + company
				+ ", userPostedJob=" + userPostedJob + ", jobPostActivity=" + jobPostActivity + ", jobPostSkillSet="
				+ jobPostSkillSet + ", jobLocation=" + jobLocation + ", jobDescription=" + jobDescription
				+ ", isActive=" + isActive + ", jobPositionName=" + jobPositionName + ", dateCreate=" + dateCreated
				+ "]";
	}
	
  	

}
