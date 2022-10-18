package com.aabdenbaoui.management.entity.enums;

public enum DegreeEnum {
	
	AB("Bachelor of Arts"),
	BS("Bachelor of Science"),
	AA("Associate of Arts"),
	AS("Associate of Science");

	 
	private String degree;
	   
	private DegreeEnum(String degree) {
		this.degree = degree;
	}

	public String getDegree() {
		return degree;
	}



}
