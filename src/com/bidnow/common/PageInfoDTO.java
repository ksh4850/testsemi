package com.bidnow.common;

public class PageInfoDTO implements java.io.Serializable {
	
	
	private static final long serialVersionUID = 156717959132683325L;
	private int pageNo;		//요청한 페이지번호
	private int totalCount;	//전체 게시물수
	private int limit;		//한 페이지에 보여출 게시물수
	private int buttonAmount;//한 번에 보여줄 페이징 버튼수 
	private int maxPage;	//가장 마지막 페이지
	private int startPage;	//한번에 보여줄 페이징 버튼의 시작하는 페이지
	private int endPage;	//한번에 보여줄 페이징 버튼의 마지막 페이지
	private int starRow;	//db조회시 최신글부터 조회해야 하는 행의 시작 row수
	private int endPow;		//db조회시 최신글부터 조회해야 하는 행의 마지막 row수
	
	public PageInfoDTO() {
	
	}
	
	public PageInfoDTO(int pageNo, int totalCount, int limit, int buttonAmount, int maxPage, int startPage, int endPage,
			int starRow, int endPow) {
		super();
		this.pageNo = pageNo;
		this.totalCount = totalCount;
		this.limit = limit;
		this.buttonAmount = buttonAmount;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.starRow = starRow;
		this.endPow = endPow;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getButtonAmount() {
		return buttonAmount;
	}
	public void setButtonAmount(int buttonAmount) {
		this.buttonAmount = buttonAmount;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStarRow() {
		return starRow;
	}
	public void setStarRow(int starRow) {
		this.starRow = starRow;
	}
	public int getEndPow() {
		return endPow;
	}
	public void setEndPow(int endPow) {
		this.endPow = endPow;
	}
	@Override
	public String toString() {
		return "PageInfoDTO [pageNo=" + pageNo + ", totalCount=" + totalCount + ", limit=" + limit + ", buttonAmount="
				+ buttonAmount + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", starRow=" + starRow + ", endPow=" + endPow + "]";
	}

}
