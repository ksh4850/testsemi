package com.bidnow.post.model.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.bidnow.user.model.dto.UserDTO;

public class PostDTO implements java.io.Serializable  {
	

	private static final long serialVersionUID = -323610054597310666L;
	private String postNo;
	private UserDTO seller;	
	private CategoryDTO category;
	private java.sql.Date postedDate;
	private String title;
	private String details;
	private String postCheck;
	private String dealingCheck;
	private int minPrice;
	private List<ImgDTO> imgList;
	private String unOpenedchk;
	private java.sql.Timestamp bidEndDate;
	private String bidStatus;
	private List<BidDTO> bidList;
	private List<InquiryDTO> inquiryList;
	
	public PostDTO() {
	
	}

	public PostDTO(String postNo, UserDTO seller, CategoryDTO category, Date postedDate, String title, String details,
			String postCheck, String dealingCheck, int minPrice, List<ImgDTO> imgList, String unOpenedchk,
			Timestamp bidEndDate, String bidStatus, List<BidDTO> bidList, List<InquiryDTO> inquiryList) {
		super();
		this.postNo = postNo;
		this.seller = seller;
		this.category = category;
		this.postedDate = postedDate;
		this.title = title;
		this.details = details;
		this.postCheck = postCheck;
		this.dealingCheck = dealingCheck;
		this.minPrice = minPrice;
		this.imgList = imgList;
		this.unOpenedchk = unOpenedchk;
		this.bidEndDate = bidEndDate;
		this.bidStatus = bidStatus;
		this.bidList = bidList;
		this.inquiryList = inquiryList;
	}

	public String getPostNo() {
		return postNo;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public UserDTO getSeller() {
		return seller;
	}

	public void setSeller(UserDTO seller) {
		this.seller = seller;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public java.sql.Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(java.sql.Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getPostCheck() {
		return postCheck;
	}

	public void setPostCheck(String postCheck) {
		this.postCheck = postCheck;
	}

	public String getDealingCheck() {
		return dealingCheck;
	}

	public void setDealingCheck(String dealingCheck) {
		this.dealingCheck = dealingCheck;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public List<ImgDTO> getImgList() {
		return imgList;
	}

	public void setImgList(List<ImgDTO> imgList) {
		this.imgList = imgList;
	}

	public String getUnOpenedchk() {
		return unOpenedchk;
	}

	public void setUnOpenedchk(String unOpenedchk) {
		this.unOpenedchk = unOpenedchk;
	}

	public java.sql.Timestamp getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(java.sql.Timestamp bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public String getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

	public List<BidDTO> getBidList() {
		return bidList;
	}

	public void setBidList(List<BidDTO> bidList) {
		this.bidList = bidList;
	}

	public List<InquiryDTO> getInquiryList() {
		return inquiryList;
	}

	public void setInquiryList(List<InquiryDTO> inquiryList) {
		this.inquiryList = inquiryList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PostDTO [postNo=" + postNo + ", seller=" + seller + ", category=" + category + ", postedDate="
				+ postedDate + ", title=" + title + ", details=" + details + ", postCheck=" + postCheck
				+ ", dealingCheck=" + dealingCheck + ", minPrice=" + minPrice + ", imgList=" + imgList
				+ ", unOpenedchk=" + unOpenedchk + ", bidEndDate=" + bidEndDate + ", bidStatus=" + bidStatus
				+ ", bidList=" + bidList + ", inquiryList=" + inquiryList + "]";
	}

	
	
	

	
	


	

		
	
	
	
	
	
	
	
	
	
	

}
