package com.aabdenbaoui.management.entity.seekerprofilebuilder;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class TimeLine {
	@NotNull
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 @Column(name = "start_date")
	private LocalDate startDate;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "end_date")
	private LocalDate endDate;

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	   
	   
	   
	
}
