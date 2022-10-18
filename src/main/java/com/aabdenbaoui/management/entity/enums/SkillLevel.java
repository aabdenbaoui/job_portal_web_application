package com.aabdenbaoui.management.entity.enums;

public enum SkillLevel {
	
	BEGINEER("Begineer"), 
    INTERMEDIATE("Intermediate"), 
	EXPERIENCED("Experienced"), 
	PROFICIENT("Proficient"),
	EXPERT("Expert");
	
	private String skillLevel;
	   
	private SkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}

	public String getMajor() {
		return skillLevel;
	}

}
