package com.aabdenbaoui.management.entity.seekerprofilebuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.aabdenbaoui.management.entity.enums.SkillLevel;

@Entity
@Table(name = "seeker_skill")
public class SeekerSkill {

	@Id
	@GeneratedValue
	private long seekerSkillId;
	@Column(name = "skill_level")
	private SkillLevel skillLevel;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "skill_name_id_fk")
	private SkillName skillSet;
	public long getSeekerSkillId() {
		return seekerSkillId;
	}
	public void setSeekerSkillId(long seekerSkillId) {
		this.seekerSkillId = seekerSkillId;
	}
	public SkillLevel getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}
	public SkillName getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(SkillName skillSet) {
		this.skillSet = skillSet;
	}
	
	
	
}
