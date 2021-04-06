package semitest1.bidnow.user.model.dto;

import java.sql.Date;

public class UserDTO implements java.io.Serializable {
	

	private static final long serialVersionUID = 8118191385292757611L;
	private String no;
	private String id;
	private String pwd;
	private String name;
	private String address;
	private String mobile;
	private String email;
	private java.sql.Date regist_day;
	private String leace_chk;
	private int deposit;
	private String lvCode;
	private String lvName;
	private int dealingScore;
	
	public UserDTO() {
		
	}

	public UserDTO(String no, String id, String pwd, String name, String address, String mobile, String email,
			Date regist_day, String leace_chk, int deposit, String lvCode, String lvName, int dealingScore) {
		super();
		this.no = no;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.regist_day = regist_day;
		this.leace_chk = leace_chk;
		this.deposit = deposit;
		this.lvCode = lvCode;
		this.lvName = lvName;
		this.dealingScore = dealingScore;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.sql.Date getRegist_day() {
		return regist_day;
	}

	public void setRegist_day(java.sql.Date regist_day) {
		this.regist_day = regist_day;
	}

	public String getLeace_chk() {
		return leace_chk;
	}

	public void setLeace_chk(String leace_chk) {
		this.leace_chk = leace_chk;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public String getLvCode() {
		return lvCode;
	}

	public void setLvCode(String lvCode) {
		this.lvCode = lvCode;
	}

	public String getLvName() {
		return lvName;
	}

	public void setLvName(String lvName) {
		this.lvName = lvName;
	}

	public int getDealingScore() {
		return dealingScore;
	}

	public void setDealingScore(int dealingScore) {
		this.dealingScore = dealingScore;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserDTO [no=" + no + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", address=" + address
				+ ", mobile=" + mobile + ", email=" + email + ", regist_day=" + regist_day + ", leace_chk=" + leace_chk
				+ ", deposit=" + deposit + ", lvCode=" + lvCode + ", lvName=" + lvName + ", dealingScore="
				+ dealingScore + "]";
	}

	
	
	
	
	
	
	
	
	
	

}
