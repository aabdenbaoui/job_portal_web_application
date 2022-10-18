package com.aabdenbaoui.management.entity.company;

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
import javax.validation.constraints.NotNull;

import com.aabdenbaoui.management.personal_validators.AddressConstraint;
import com.aabdenbaoui.management.personal_validators.CompanyAddressConstraint;

@Entity
@Table(name = "company")
public class Company {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "company_id_pk")
	 private long companyId;
	 @Column(name = "company_name")
	 private String companyName;
	 @Column(name = "profile_description")
	 private String profileDescription;
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name = "company_image_id_fk")
     private CompanyImage companyImage;
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name = "business_stream_id_fk")
     private BusinessStream businessStream;
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name = "company_address_id_fk")
	 @NotNull
     private CompanyAddress companyAddress;
	 
	public Company() {
	}
	public Company(String companyName, String profileDescription, CompanyImage companyImage,
			BusinessStream businessStream, CompanyAddress companyAddress) {
		this.companyName = companyName;
		this.profileDescription = profileDescription;
		this.companyImage = companyImage;
		this.businessStream = businessStream;
		this.companyAddress = companyAddress;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getProfileDescription() {
		return profileDescription;
	}
	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}
	public CompanyImage getCompanyImage() {
		return companyImage;
	}
	public void setCompanyImage(CompanyImage companyImage) {
		this.companyImage = companyImage;
	}
	public BusinessStream getBusinessStream() {
		return businessStream;
	}
	public void setBusinessStream(BusinessStream businessStream) {
		this.businessStream = businessStream;
	}
	public CompanyAddress getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(CompanyAddress companyAddress) {
		this.companyAddress = companyAddress;
	}


}
