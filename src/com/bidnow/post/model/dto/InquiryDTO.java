package com.bidnow.post.model.dto;

import java.sql.Date;

import com.bidnow.user.model.dto.UserDTO;


public class InquiryDTO implements java.io.Serializable {

	private static final long serialVersionUID = 3616063140548432070L;
	private String inquiryNo;
	private String postNo;
	private UserDTO purchaser;
	private String inquiryDetails;
	private java.sql.Date inquiryDate;
	private String response;
	private java.sql.Date responseDate;
	private String responseStatue;
	private String secretStatus;
	private String inquiryStatus ;
	
	public InquiryDTO() {
		
	}

	public InquiryDTO(String inquiryNo, String postNo, UserDTO purchaser, String inquiryDetails, Date inquiryDate,
			String response, Date responseDate, String responseStatue, String secretStatus, String inquiryStatus) {
		super();
		this.inquiryNo = inquiryNo;
		this.postNo = postNo;
		this.purchaser = purchaser;
		this.inquiryDetails = inquiryDetails;
		this.inquiryDate = inquiryDate;
		this.response = response;
		this.responseDate = responseDate;
		this.responseStatue = responseStatue;
		this.secretStatus = secretStatus;
		this.inquiryStatus = inquiryStatus;
	}

	public String getInquiryNo() {
		return inquiryNo;
	}

	public void setInquiryNo(String inquiryNo) {
		this.inquiryNo = inquiryNo;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public UserDTO getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(UserDTO purchaser) {
		this.purchaser = purchaser;
	}

	public String getInquiryDetails() {
		return inquiryDetails;
	}

	public void setInquiryDetails(String inquiryDetails) {
		this.inquiryDetails = inquiryDetails;
	}

	public java.sql.Date getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(java.sql.Date inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public java.sql.Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(java.sql.Date responseDate) {
		this.responseDate = responseDate;
	}

	public String getResponseStatue() {
		return responseStatue;
	}

	public void setResponseStatue(String responseStatue) {
		this.responseStatue = responseStatue;
	}

	public String getSecretStatus() {
		return secretStatus;
	}

	public void setSecretStatus(String secretStatus) {
		this.secretStatus = secretStatus;
	}

	public String getInquiryStatus() {
		return inquiryStatus;
	}

	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "InquiryDTO [inquiryNo=" + inquiryNo + ", postNo=" + postNo + ", purchaser=" + purchaser
				+ ", inquiryDetails=" + inquiryDetails + ", inquiryDate=" + inquiryDate + ", response=" + response
				+ ", responseDate=" + responseDate + ", responseStatue=" + responseStatue + ", secretStatus="
				+ secretStatus + ", inquiryStatus=" + inquiryStatus + "]";
	}

	
	

	
	
	
	
	
	
	
	
	

	
	

}
