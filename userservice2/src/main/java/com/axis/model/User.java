package com.axis.model;

import java.io.Serializable;

import java.sql.Timestamp;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "user50")
public class User implements Serializable {

	@Id
	private ObjectId id;
	private String holderName;
	private int age;
	private Long phoneNumber;
    @JsonIgnore
    private String password;
    private String role;
    private String email;
    private String address;
    private String city;
    private String state;
    private String country;
    private int pincode;
    private Timestamp createdAt;
    
    private CreditCard creditCard;
    
    
   
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public User() {
		super();
		
	}
	public User(ObjectId id, String holderName, int age, Long phoneNumber, String password, String role, String email,
			String address, String city, String state, String country, int pincode, Timestamp createdAt,
			CreditCard creditCard) {
		super();
		this.id = id;
		this.holderName = holderName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.createdAt = createdAt;
		this.creditCard = creditCard;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
}


