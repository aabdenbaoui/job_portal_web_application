package com.aabdenbaoui.management.entity.jobpost;

import java.time.LocalDate;

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

import com.aabdenbaoui.management.entity.managingusers.User;

@Entity
@Table(name = "job_post_activity")
public class JobPostActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "job_post_activity_pk")
	private long jobActivityId;
	@Column(name = "apply_date")
	private LocalDate applyDate;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id_fk")
	private User userAccount;
	
	public JobPostActivity() {
	}
	
	public long getJobActivityId() {
		return jobActivityId;
	}
	public void setJobActivityId(long jobActivityId) {
		this.jobActivityId = jobActivityId;
	}
	public LocalDate getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(LocalDate applyDate) {
		this.applyDate = applyDate;
	}
	public User getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(User userAccount) {
		this.userAccount = userAccount;
	}
	
	
	
	
	
}
