package com.aabdenbaoui.management.entity.company;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "company_image")
public class CompanyImage {
	
	@Id
	@GeneratedValue
	private long companyImageId;
	@Column(name = "company_image")
	private Blob companyImage;
	public long getCompanyImageId() {
		return companyImageId;
	}
	public void setCompanyImageId(long companyImageId) {
		this.companyImageId = companyImageId;
	}
	public Blob getCompanyImage() {
		return companyImage;
	}
	public void setCompanyImage(Blob companyImage) {
		this.companyImage = companyImage;
	}
	public CompanyImage() {
	}
	
	
	

}
