package com.demo.example.chatbot.loginvalidation;

import java.util.Set;

public class LoginValidationDetails {
	private String id;
	private Set<String> role;
	private String firstName;
	private String lastName;
	private String email;
	private String imageUrl;
	private Long mobile;
	private String registrationType;
	private String approvalStatus;
	private String approvedBy;
	public LoginValidationDetails() {
		super();
	}
	public LoginValidationDetails(String id, Set<String> role, String firstName, String lastName, String email,
			String imageUrl, Long mobile, String registrationType, String approvalStatus, String approvedBy) {
		super();
		this.id = id;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.imageUrl = imageUrl;
		this.mobile = mobile;
		this.registrationType = registrationType;
		this.approvalStatus = approvalStatus;
		this.approvedBy = approvedBy;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Set<String> getRole() {
		return role;
	}
	public void setRole(Set<String> role) {
		this.role = role;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getRegistrationType() {
		return registrationType;
	}
	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	@Override
	public String toString() {
		return "LoginValidationDetails [id=" + id + ", role=" + role + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", imageUrl=" + imageUrl + ", mobile=" + mobile
				+ ", registrationType=" + registrationType + ", approvalStatus=" + approvalStatus + ", approvedBy="
				+ approvedBy + ", getId()=" + getId() + ", getRole()=" + getRole() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail()
				+ ", getImageUrl()=" + getImageUrl() + ", getMobile()=" + getMobile() + ", getRegistrationType()="
				+ getRegistrationType() + ", getApprovalStatus()=" + getApprovalStatus() + ", getApprovedBy()="
				+ getApprovedBy() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
