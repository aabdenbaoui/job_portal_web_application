package com.aabdenbaoui.management.entity.seekerprofilebuilder;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aabdenbaoui.management.entity.enums.DegreeEnum;
import com.aabdenbaoui.management.entity.enums.Major;
import com.aabdenbaoui.management.personal_validators.StartDateEndDateConstraint;

@Entity
@Table(name = "education_detail")
public class EducationDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long educationDetailId;
	@Enumerated(EnumType.STRING)
	private DegreeEnum certificateDegreeName;
	@Enumerated(EnumType.STRING)
	private Major major;
	
	private String university_name;
	@Embedded
    @StartDateEndDateConstraint
	private TimeLine timeLine;
	
	 @ManyToOne
	 @JoinColumn(name = "seeker_profile_id_pk")
	 private SeekerProfile seekerProfile;
	
	private Double cumulativeGpa;

	public EducationDetail() {
	}

	public long getEducationDetailId() {
		return educationDetailId;
	}

	public void setEducationDetailId(long educationDetailId) {
		this.educationDetailId = educationDetailId;
	}

	public DegreeEnum getCertificateDegreeName() {
		return certificateDegreeName;
	}

	public void setCertificateDegreeName(DegreeEnum certificateDegreeName) {
		this.certificateDegreeName = certificateDegreeName;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getUniversity_name() {
		return university_name;
	}

	public void setUniversity_name(String university_name) {
		this.university_name = university_name;
	}

	public TimeLine getTimeLine() {
		return timeLine;
	}

	public void setTimeLine(TimeLine timeLine) {
		this.timeLine = timeLine;
	}

	public Double getCumulativeGpa() {
		return cumulativeGpa;
	}

	public void setCumulativeGpa(Double cumulativeGpa) {
		this.cumulativeGpa = cumulativeGpa;
	}

	public SeekerProfile getSeekerProfile() {
		return seekerProfile;
	}

	public void setSeekerProfile(SeekerProfile seekerProfile) {
		this.seekerProfile = seekerProfile;
	}
	
	
	

}
