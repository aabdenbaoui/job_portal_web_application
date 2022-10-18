package com.aabdenbaoui.management.entity.managingusers;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_log")
public class UserLog {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long logId;
	 @Column(name = "user_login_date")
	 private LocalDate lastLoginDate;
	 @Column(name = "last_job_apply_date")
	 private LocalDate lastJobApply;
	 
	 
	 
	public UserLog() {
	}
	public UserLog(LocalDate lastLoginDate, LocalDate lastJobApply) {
		this.lastLoginDate = lastLoginDate;
		this.lastJobApply = lastJobApply;
	}
	public long getLogId() {
		return logId;
	}
	public void setLogId(long logId) {
		this.logId = logId;
	}
	public LocalDate getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(LocalDate lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public LocalDate getLastJobApply() {
		return lastJobApply;
	}
	public void setLastJobApply(LocalDate lastJobApply) {
		this.lastJobApply = lastJobApply;
	}
	 
	 
	 
	
}
