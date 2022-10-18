package com.aabdenbaoui.management.entity.enums;

public enum Major {

	BA("Business Administration"),
	ACCT("Accounting"),
	NUR("Nursing"),
	PSY("Psychology"),
	COMM("Communications"),
	MKT("Marketing"),
	EDU("Education"),
	EEDU("Elementary Education"),
	ENG("English"),
	CS("Computer Science"),
	FIN("Finance"),
	CJ("Criminal Justice"),
	BIO("Biology"),
	PS("Political Science"),
	ECON("Economics"),
	EE("Electrical Engineering"),
	HIST("History"),
	LA("Liberal Arts"),
	SOC("Sociology"),
	FA("Fine Arts"),
	CAGD("Commercial Art & Graphic Design"),
	GE("General Engineering"),
	JRNL("Journalism"),
	CIS("Computer and Information Systems"),
	SW("Social Work");
	 
	private String major;
	   
	private Major(String major) {
		this.major = major;
	}

	public String getMajor() {
		return major;
	}
}
