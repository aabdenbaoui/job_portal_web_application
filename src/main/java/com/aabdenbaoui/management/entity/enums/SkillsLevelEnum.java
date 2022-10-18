package com.aabdenbaoui.management.entity.enums;

public enum SkillsLevelEnum {

	 JR("Junior"),
	 ML("Mid-Level"),
	 SR("Senior");
	 
	  private String name;
	   
	  private SkillsLevelEnum(String name) {
			this.name = name;
		}

      public String getName() {
			return name;
		}
}
