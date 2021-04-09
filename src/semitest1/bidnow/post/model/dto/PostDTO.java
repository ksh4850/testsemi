package semitest1.bidnow.post.model.dto;

import java.sql.Date;
import java.util.List;

import semitest1.bidnow.user.model.dto.UserDTO;

public class PostDTO implements java.io.Serializable  {
	

	private static final long serialVersionUID = -323610054597310666L;
	private String no;
	private UserDTO seller;	
	private CategoryDTO category;
	private java.sql.Date postedDate;
	private String title;
	private String details;
	private String postCheck;
	private String dealingCheck;
	private int minPrice;
	private List<ImgDTO> img;
	private String unOpenedchk;
	private java.sql.Date bidEndDate;
	private String bidStatus;
	private List<BidDTO> bidList;
	
	public PostDTO() {
	
	}

	public PostDTO(String no, UserDTO seller, CategoryDTO category, Date postedDate, String title, String details,
			String postCheck, String dealingCheck, int minPrice, List<ImgDTO> img, String unOpenedchk, Date bidEndDate,
			String bidStatus, List<BidDTO> bidList) {
		super();
		this.no = no;
		this.seller = seller;
		this.category = category;
		this.postedDate = postedDate;
		this.title = title;
		this.details = details;
		this.postCheck = postCheck;
		this.dealingCheck = dealingCheck;
		this.minPrice = minPrice;
		this.img = img;
		this.unOpenedchk = unOpenedchk;
		this.bidEndDate = bidEndDate;
		this.bidStatus = bidStatus;
		this.bidList = bidList;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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

	public List<ImgDTO> getImg() {
		return img;
	}

	public void setImg(List<ImgDTO> img) {
		this.img = img;
	}

	public String getUnOpenedchk() {
		return unOpenedchk;
	}

	public void setUnOpenedchk(String unOpenedchk) {
		this.unOpenedchk = unOpenedchk;
	}

	public java.sql.Date getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(java.sql.Date bidEndDate) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PostDTO [no=" + no + ", seller=" + seller + ", category=" + category + ", postedDate=" + postedDate
				+ ", title=" + title + ", details=" + details + ", postCheck=" + postCheck + ", dealingCheck="
				+ dealingCheck + ", minPrice=" + minPrice + ", img=" + img + ", unOpenedchk=" + unOpenedchk
				+ ", bidEndDate=" + bidEndDate + ", bidStatus=" + bidStatus + ", bidList=" + bidList + "]";
	}

	

		
	
	
	
	
	
	
	
	
	
	

}
