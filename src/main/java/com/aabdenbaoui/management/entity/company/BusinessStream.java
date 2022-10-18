package com.aabdenbaoui.management.entity.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "business_stream")
public class BusinessStream {
	
	@Id
	@GeneratedValue
	private long businessStreamId;
	@Column(name = "business_stream_name")
	private String businessStreamName;
	public long getBusinessStreamId() {
		return businessStreamId;
	}
	public void setBusinessStreamId(long businessStreamId) {
		this.businessStreamId = businessStreamId;
	}
	public String getBusinessStreamName() {
		return businessStreamName;
	}
	public void setBusinessStreamName(String businessStreamName) {
		this.businessStreamName = businessStreamName;
	}
	public BusinessStream() {
	}
	
	
	

}
