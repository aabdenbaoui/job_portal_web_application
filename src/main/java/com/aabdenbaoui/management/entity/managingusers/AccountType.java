package com.aabdenbaoui.management.entity.managingusers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aabdenbaoui.management.entity.enums.UserTypeEnum;

@Entity
@Table(name = "user_type")
public class AccountType {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "user_type_id_pk")
	 private long userTypeId;
	 @Column(name = "user_type_name")
	 @Enumerated(EnumType.STRING)
	 private UserTypeEnum userType;
	 
	 
	 
	public AccountType() {
	}
	public long getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(long userTypeId) {
		this.userTypeId = userTypeId;
	}
	public UserTypeEnum getUserType() {
		return userType;
	}
	public void setUserType(UserTypeEnum userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return userType + "";
	}

	
	 
}
