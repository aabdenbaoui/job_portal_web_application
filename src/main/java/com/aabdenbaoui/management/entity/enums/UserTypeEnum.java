package com.aabdenbaoui.management.entity.enums;


public enum UserTypeEnum {

		JOB_SEEKER("Job Seeker"), 
		HR_PERSONAL("HR Personal");
		
	
	  private String name;
	   
	  private UserTypeEnum(String name) {
			this.name = name;
		}

     public String getName() {
			return name;
		}
		  
}
