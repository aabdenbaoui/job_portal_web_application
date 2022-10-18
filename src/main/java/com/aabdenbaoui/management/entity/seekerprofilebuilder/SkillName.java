package com.aabdenbaoui.management.entity.seekerprofilebuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skill_set")
public class SkillName {
	
	@Id
	@GeneratedValue
	@Column(name = "skill_name_id_pk")
	private long skillNameId;
	@Column(name = "skill_name")
	private String skillSetName;
	public long getSkillNameId() {
		return skillNameId;
	}
	public void setSkillNameId(long skillNameId) {
		this.skillNameId = skillNameId;
	}
	public String getSkillSetName() {
		return skillSetName;
	}
	public void setSkillSetName(String skillSetName) {
		this.skillSetName = skillSetName;
	}
	
	

}
