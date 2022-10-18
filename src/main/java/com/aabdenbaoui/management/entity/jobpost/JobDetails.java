package com.aabdenbaoui.management.entity.jobpost;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aabdenbaoui.management.entity.enums.EnumJobType;
import com.aabdenbaoui.management.entity.enums.SkillsLevelEnum;

@Entity
@Table(name = "job_details")
public class JobDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_details_id_pk")
	private long JobDetailsId;
	@Column(name = "job_type")
    @Enumerated(EnumType.STRING)
	private EnumJobType jobTypeName;
    @Column(name = "salary")
    private Float salary;
    @Enumerated(EnumType.STRING)
    @Column(name = "skills_level")
    private SkillsLevelEnum skillLevel;
	public long getJobDetailsId() {
		return JobDetailsId;
	}
	public void setJobDetailsId(long jobDetailsId) {
		JobDetailsId = jobDetailsId;
	}
	public EnumJobType getJobTypeName() {
		return jobTypeName;
	}
	public void setJobTypeName(EnumJobType jobTypeName) {
		this.jobTypeName = jobTypeName;
	}
	public Float getSalary() {
		return salary;
	}
	public SkillsLevelEnum getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(SkillsLevelEnum skillLevel) {
		this.skillLevel = skillLevel;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
    
    
    
}
