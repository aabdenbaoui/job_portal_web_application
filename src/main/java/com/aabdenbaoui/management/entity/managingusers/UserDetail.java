package com.aabdenbaoui.management.entity.managingusers;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.aabdenbaoui.management.entity.enums.Gender;
import com.aabdenbaoui.management.personal_validators.AddressConstraint;
import com.aabdenbaoui.management.personal_validators.DateOfBirthConstraint;

@Entity
@Table(name ="user_detail")
public class UserDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="user_detail_id_pk")
	private long userDetailId;
	@Column(name = "gender")
    @Enumerated(EnumType.STRING)
	private Gender gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateOfBirthConstraint(message = "You have to be 18 years old to register")
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
    @Pattern(regexp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$", message = "Wrong US phone number format")
	@Column(name = "contact_number")
	private String contactNumber;
	@Column(name = "sms_notification_active")
	private boolean smsNotificationIsActive;
	@Column(name = "email_notification_active")
	private boolean emailNotificationIsActive;
	@Column(name = "is_active")
	private boolean isActive;
	
	//user_log
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_log_id_fk")
	private UserLog userLog;
	//user_address
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_address_id_fk")
	@AddressConstraint
	private Address address;
	
	
	public UserDetail() {
		isActive = true;
	}
	public long getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(long userDetailId) {
		this.userDetailId = userDetailId;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public boolean isSmsNotificationIsActive() {
		return smsNotificationIsActive;
	}
	public void setSmsNotificationIsActive(boolean smsNotificationIsActive) {
		this.smsNotificationIsActive = smsNotificationIsActive;
	}
	public boolean isEmailNotificationIsActive() {
		return emailNotificationIsActive;
	}
	public void setEmailNotificationIsActive(boolean emailNotificationIsActive) {
		this.emailNotificationIsActive = emailNotificationIsActive;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public UserLog getUserLog() {
		return userLog;
	}
	public void setUserLog(UserLog userLog) {
		this.userLog = userLog;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", contactNumber=" + contactNumber + ", smsNotificationIsActive=" + smsNotificationIsActive
				+ ", emailNotificationIsActive=" + emailNotificationIsActive + ", isActive=" + isActive + ", userLog="
				+ userLog + ", address=" + address.getCity() + "]";
	}
	
	
	
	

}
