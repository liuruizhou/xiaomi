package com.mi.liuruizhou.dao.po;

public class User {
	private int userId;
	private String userAccount;
	private String userNickname;
	private	String password;
	private	String phone;
	private	String personalizedSignature;
	private String hobby;
	private String address;
	public User() {
		super();
	}
	public User(int userId, String userAccount, String userNickname, String password, String phone,
			String personalizedSignature, String hobby, String address) {
		super();
		this.userId = userId;
		this.userAccount = userAccount;
		this.userNickname = userNickname;
		this.password = password;
		this.phone = phone;
		this.personalizedSignature = personalizedSignature;
		this.hobby = hobby;
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPersonalizedSignature() {
		return personalizedSignature;
	}
	public void setPersonalizedSignature(String personalizedSignature) {
		this.personalizedSignature = personalizedSignature;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount + ", userNickname=" + userNickname
				+ ", password=" + password + ", phone=" + phone + ", personalizedSignature=" + personalizedSignature
				+ ", hobby=" + hobby + ", address=" + address + "]";
	}
	
}
