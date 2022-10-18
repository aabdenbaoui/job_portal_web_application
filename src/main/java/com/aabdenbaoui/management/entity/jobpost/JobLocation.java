package com.aabdenbaoui.management.entity.jobpost;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aabdenbaoui.management.entity.enums.State;
@Entity
@Table(name = "job_location")
public class JobLocation {

	  @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "job_location_pk_int")
	  public long jobLocationId;
	  
	  private String streetAddress;
	  @Column(name = "city")
	  private String city;
	  @Enumerated(EnumType.STRING)
	  private State state;
	  
	  private String zipCode;

	public long getJobLocationId() {
		return jobLocationId;
	}

	public void setJobLocationId(long jobLocationId) {
		this.jobLocationId = jobLocationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public JobLocation(String streetAddress, String city, State state, String zipCode) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public JobLocation() {
	}
	
	  
	  
	  
	  
}
