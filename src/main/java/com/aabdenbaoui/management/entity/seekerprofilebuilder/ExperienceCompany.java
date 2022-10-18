package com.aabdenbaoui.management.entity.seekerprofilebuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "experience_company")
public class ExperienceCompany {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "experience_company_id_pk")
	 private long ExperienceCompanyId;
	 @Column(name = "experience_company_name")
	 private String companyName;
	
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name = "experience_company_address_id_fk")
	 @NotNull
    private ExperienceCompanyAddress experienceCompanyAddress;
	 

	public ExperienceCompany() {
	}

	public long getExperienceCompanyId() {
		return ExperienceCompanyId;
	}

	public void setExperienceCompanyId(long experienceCompanyId) {
		ExperienceCompanyId = experienceCompanyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public ExperienceCompanyAddress getExperienceCompanyAddress() {
		return experienceCompanyAddress;
	}

	public void setExperienceCompanyAddress(ExperienceCompanyAddress experienceCompanyAddress) {
		this.experienceCompanyAddress = experienceCompanyAddress;
	}


	

}
