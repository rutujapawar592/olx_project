package com.olx.login.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LoginService DTO")
public class User {
	
	@ApiModelProperty(value = "ID")
	private int Id;
	@ApiModelProperty(value = "FirstName")
	private String firstName;
	@ApiModelProperty(value = "LastName")
	private String lastName;
	@ApiModelProperty(value = "UserName")
	private String userName;
	@ApiModelProperty(value = "Password")
	private String password;
	@ApiModelProperty(value = "Email")
	private String email;
	@ApiModelProperty(value = "Phone Number")
	private String phoneNumber;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int Id,String firstName, String lastName, String userName, String password, String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
