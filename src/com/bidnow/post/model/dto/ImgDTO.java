package com.bidnow.post.model.dto;

public class ImgDTO {
	
	private String fileNo;
	private String postNo;
	private String orgFileName;
	private String reFileName;
	private String thnFileName;
	private String savePath;
	
	public ImgDTO() {
		
	}
	
	public ImgDTO(String fileNo, String postNo, String orgFileName, String reFileName, String thnFileName,
			String savePath) {
		super();
		this.fileNo = fileNo;
		this.postNo = postNo;
		this.orgFileName = orgFileName;
		this.reFileName = reFileName;
		this.thnFileName = thnFileName;
		this.savePath = savePath;
	}


	public String getFileNo() {
		return fileNo;
	}


	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}


	public String getPostNo() {
		return postNo;
	}


	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}


	public String getOrgFileName() {
		return orgFileName;
	}


	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}


	public String getReFileName() {
		return reFileName;
	}


	public void setReFileName(String reFileName) {
		this.reFileName = reFileName;
	}


	public String getThnFileName() {
		return thnFileName;
	}


	public void setThnFileName(String thnFileName) {
		this.thnFileName = thnFileName;
	}


	public String getSavePath() {
		return savePath;
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}


	@Override
	public String toString() {
		return "ImgDTO [fileNo=" + fileNo + ", postNo=" + postNo + ", orgFileName=" + orgFileName + ", reFileName="
				+ reFileName + ", thnFileName=" + thnFileName + ", savePath=" + savePath + "]";
	}
	
	
	
	
	
	


}
