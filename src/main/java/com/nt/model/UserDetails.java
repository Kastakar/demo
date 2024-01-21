package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

@GeneratedValue
@Id
@Column(name="userId")
private Integer userId;
@Column(name="UserName")
private String userName;
@Column(name="MobileNumber")
private String mobileNumber;
@Column(name="EmailAddress")
private String emailAddress;
@Column(name="ActiveSwitch")
private String activeSwitch;
@Column(name="City")
private String city;


@Column(name="tempPassword")
private String tempPassword;

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getEmailAddress() {
	return emailAddress;
}
public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}
public String getActiveSwitch() {
	return activeSwitch;
}
public void setActiveSwitch(String activeSwitch) {
	this.activeSwitch = activeSwitch;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}




public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return "UserDetails [userId=" + userId + ", userName=" + userName + ", mobileNumber=" + mobileNumber
			+ ", emailAddress=" + emailAddress + ", activeSwitch=" + activeSwitch + ", city=" + city + ", tempPassword="
			+ tempPassword + "]";
}



	
	
}
