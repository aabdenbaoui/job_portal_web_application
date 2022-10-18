package com.aabdenbaoui.management.entity.seekerprofilebuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.aabdenbaoui.management.personal_validators.CompanyAddressConstraint;
import com.aabdenbaoui.management.personal_validators.StartDateEndDateConstraint;


@Entity
@Table(name = "experience_detail")
public class ExperienceDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_detail_id_pk")
	private long experienceDetailId;
	@Column(name = "is_current_job")
	private boolean currentJob;
     @Embedded
     @StartDateEndDateConstraint
	private TimeLine timeLine;
	@Column(name = "job_title")
	private String jobTitle;
	@Column(name = "salary")
	private Double salary;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "experience_company_id_fk")
	private ExperienceCompany experienceCompany;
  
	@Column(name = "work_Experiencec_Description")
	private String workExperienceDescription;
	 @ManyToOne
	 @JoinColumn(name = "seeker_profile_id_pk")
	 private SeekerProfile seekerProfile;
//	


	public ExperienceDetail() {
		// TODO Auto-generated constructor stub
	}


	public long getExperienceDetailId() {
		return experienceDetailId;
	}


	public void setExperienceDetailId(long experienceDetailId) {
		this.experienceDetailId = experienceDetailId;
	}


	public boolean isCurrentJob() {
		return currentJob;
	}


	public void setCurrentJob(boolean currentJob) {
		this.currentJob = currentJob;
	}


	public TimeLine getTimeLine() {
		return timeLine;
	}


	public void setTimeLine(TimeLine timeLine) {
		this.timeLine = timeLine;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public ExperienceCompany getExperienceCompany() {
		return experienceCompany;
	}


	public void setExperienceCompany(ExperienceCompany experienceCompany) {
		this.experienceCompany = experienceCompany;
	}


	public String getWorkExperienceDescription() {
		return workExperienceDescription;
	}


	public void setWorkExperienceDescription(String description) {
		this.workExperienceDescription = description;
	}


	public SeekerProfile getSeekerProfile() {
		return seekerProfile;
	}


	public void setSeekerProfile(SeekerProfile seekerProfile) {
		this.seekerProfile = seekerProfile;
	}


}
