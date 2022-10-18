
package com.aabdenbaoui.management.entity.enums;

public enum EnumJobType {

	CONTRACT_PART_TIME("Contract Part Time"),
	CONTRACT_FULL_TIME("Contact Full Time"),
	PERMANENT_PART_TIME("Permanent Part Time"),
	PERMANENT_FULL_TIME("Permanent Full Time");
	
	
	private String name;
	
	EnumJobType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	
}
