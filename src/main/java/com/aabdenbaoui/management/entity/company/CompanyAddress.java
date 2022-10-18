package com.aabdenbaoui.management.entity.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.aabdenbaoui.management.entity.enums.State;

@Entity
@Table(name = "company_address")
public class CompanyAddress {

	 @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private long companyAddressId;
	 @Column(name ="street_address")
	 private  String streetAddress;
	 @Column(name = "city")
	 private String city;
	 @Column(name = "state")
	 @Enumerated(EnumType.STRING)
	 @NotEmpty
	 private State state;
	 @Column(name = "zip_code")
	 @NotEmpty
	 private String zipCode;
	 
	public long getCompanyAddressId() {
		return companyAddressId;
	}

	public void setCompanyAddressId(long companyAddressId) {
		this.companyAddressId = companyAddressId;
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

	public CompanyAddress() {
	}
	 
	 
	 
	 
	 
	
}
