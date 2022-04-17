package com.olx.login.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "USERS")
public class UserEntity {
	
	@Id
	@GeneratedValue
	private int Id;
	//@Column(name = "First_Name")
	private String firstName;
	//@Column(name = "Last_Name")
	private String lastName;
	//@Column(name = "UserName")
	private String userName;
	//@Column(name = "Password")
	private String password;
	//@Column(name = "Email")
	private String email;
	//@Column(name = "PhoneNumber")
	private String phoneNumber;
	
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(int Id,String firstName, String lastName, String userName, String password, String email, String phoneNumber) {
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
