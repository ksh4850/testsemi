package com.bidnow.post.model.dto;

import java.sql.Date;

import com.bidnow.user.model.dto.UserDTO;

public class BidDTO implements java.io.Serializable  {
	

	private static final long serialVersionUID = -4493656452612399650L;
	private String bidNo;
	private String postNo;
	private UserDTO purchser;
	private int bidPrice;
	private java.sql.Date bidDate;
	private String dealingCheck;
	private String bidStatus;
	
	public BidDTO() {
		
	}

	public BidDTO(String bidNo, String postNo, UserDTO purchser, int bidPrice, Date bidDate, String dealingCheck,
			String bidStatus) {
		super();
		this.bidNo = bidNo;
		this.postNo = postNo;
		this.purchser = purchser;
		this.bidPrice = bidPrice;
		this.bidDate = bidDate;
		this.dealingCheck = dealingCheck;
		this.bidStatus = bidStatus;
	}

	public String getBidNo() {
		return bidNo;
	}

	public void setBidNo(String bidNo) {
		this.bidNo = bidNo;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public UserDTO getPurchser() {
		return purchser;
	}

	public void setPurchser(UserDTO purchser) {
		this.purchser = purchser;
	}

	public int getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}

	public java.sql.Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(java.sql.Date bidDate) {
		this.bidDate = bidDate;
	}

	public String getDealingCheck() {
		return dealingCheck;
	}

	public void setDealingCheck(String dealingCheck) {
		this.dealingCheck = dealingCheck;
	}

	public String getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BidDTO [bidNo=" + bidNo + ", postNo=" + postNo + ", purchser=" + purchser + ", bidPrice=" + bidPrice
				+ ", bidDate=" + bidDate + ", dealingCheck=" + dealingCheck + ", bidStatus=" + bidStatus + "]";
	}

	
	
	
		
	
}
