package com.aabdenbaoui.management.entity.managingusers;

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
@Table(name = "user_address")
public class Address {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "user_address_id_pk")
	 private long address_id;
	 @Column(name = "street_address")
	 private String streetAddress;
	 @Column(name = "city")
	 private String city;
	 @Enumerated(EnumType.STRING)
	@Column(name ="state")
	private State state;
	@Column(name = "zip_code")
	private String zipCode;
	public Address(String streetAddress, String city, State state, String zipCode) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public Address() {
	}
	public long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(long address_id) {
		this.address_id = address_id;
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
	
	
	
	
	
}
