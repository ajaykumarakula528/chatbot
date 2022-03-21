package com.demo.example.chatbot.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String adress;
	private String city;
	private Long phonenumber;
	private Long pincode;
	private Set<String> role;

	public User() {
		super();
	}

	public String getId() {
		return id;
	}

	public User(Set<String> role) {
		super();
		this.role = role;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", adress=" + adress + ", city=" + city + ", phonenumber=" + phonenumber
				+ ", pincode=" + pincode + ", role=" + role + ", getId()=" + getId() + ", getFirstname()="
				+ getFirstname() + ", getLastname()=" + getLastname() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getAdress()=" + getAdress() + ", getCity()=" + getCity()
				+ ", getPhonenumber()=" + getPhonenumber() + ", getPincode()=" + getPincode() + ", getRole()="
				+ getRole() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
