package com.bidnow.post.model.dto;

public class CategoryDTO implements java.io.Serializable {
	
	

	private static final long serialVersionUID = -5027473384841871718L;

	private String ctgLCode;
	private String ctgLName;
	private String ctgSCode;
	private String ctgSName;
	
	public CategoryDTO() {
		
	}
	
	public CategoryDTO(String ctgLCode, String ctgLName, String ctgSCode, String ctgSName) {
		super();
		this.ctgLCode = ctgLCode;
		this.ctgLName = ctgLName;
		this.ctgSCode = ctgSCode;
		this.ctgSName = ctgSName;
	}
	public String getCtgLCode() {
		return ctgLCode;
	}
	public void setCtgLCode(String ctgLCode) {
		this.ctgLCode = ctgLCode;
	}
	public String getCtgLName() {
		return ctgLName;
	}
	public void setCtgLName(String ctgLName) {
		this.ctgLName = ctgLName;
	}
	public String getCtgSCode() {
		return ctgSCode;
	}
	public void setCtgSCode(String ctgSCode) {
		this.ctgSCode = ctgSCode;
	}
	public String getCtgSName() {
		return ctgSName;
	}
	public void setCtgSName(String ctgSName) {
		this.ctgSName = ctgSName;
	}
	@Override
	public String toString() {
		return "CategoryDTO [ctgLCode=" + ctgLCode + ", ctgLName=" + ctgLName + ", ctgSCode=" + ctgSCode + ", ctgSName="
				+ ctgSName + "]";
	}
	
	
	
	
	
	

	
	
	

}
