package com.wangxinyuan.dao.po;

public class User {
	private int user_id;
	private String user_account;
	private String user_nickname;
	private	String password;
	private	String phone;
	private	String personalized_signature;
	private String hobby;
	private String address;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
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
	public String getPersonalized_signature() {
		return personalized_signature;
	}
	public void setPersonalized_signature(String personalized_signature) {
		this.personalized_signature = personalized_signature;
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
	public User(int user_id, String user_account, String user_nickname, String password, String phone,
			String personalized_signature, String hobby, String address) {
		super();
		this.user_id = user_id;
		this.user_account = user_account;
		this.user_nickname = user_nickname;
		this.password = password;
		this.phone = phone;
		this.personalized_signature = personalized_signature;
		this.hobby = hobby;
		this.address = address;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_account=" + user_account + ", user_nickname=" + user_nickname
				+ ", password=" + password + ", phone=" + phone + ", personalized_signature=" + personalized_signature
				+ ", hobby=" + hobby + ", address=" + address + "]";
	}
	
}
