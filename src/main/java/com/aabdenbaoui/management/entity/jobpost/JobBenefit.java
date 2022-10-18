package com.aabdenbaoui.management.entity.jobpost;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class JobBenefit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "job_benefits_provided_id_pk")
	private long jobBenefitId;
	
	private String jobBenefitName;
	
	

}
