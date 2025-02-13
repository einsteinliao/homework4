package model;

import java.io.Serializable;

public class Member implements Serializable {

	private int id;
	private String name;
	private String loginId;
	private String password;
	private String phone;
	private String address;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Member(String name, String loginId, String password, String phone, String address) {
		super();
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String show() {
		return "id:"+ id 
				+ " name:" +name
				+ " loginId:" + loginId
				+ " phone:" + phone
				+ " address:" + address;
	}
}
