package com.aabdenbaoui.management.entity.jobpost;

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

import com.aabdenbaoui.management.entity.enums.SkillLevel;
import com.aabdenbaoui.management.entity.seekerprofilebuilder.SkillName;
@Entity
@Table(name = "job_post_skill_set")
public class JobPostSkillSet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long jobPostSkillId;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "skill_name_id_fk")
	private SkillName skillName;
	
	@Column(name = "skill_level")
	private SkillLevel skillLevel;
	

}
