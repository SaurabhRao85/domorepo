package com.axis.dto;

import java.sql.Timestamp;
import java.util.Set;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {

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
    
    
    
    private CreditCardDto creditCardDto;
    
	
	public CreditCardDto getCreditCardDto() {
		return creditCardDto;
	}
	public void setCreditCardDto(CreditCardDto creditCardDto) {
		this.creditCardDto = creditCardDto;
	}
	public UserDto() {
		super();
		
	}
	public UserDto(ObjectId id, String holderName, int age, Long phoneNumber, String password, String role, String email,
			String address, String city, String state, String country, int pincode, Timestamp createdAt,
			CreditCardDto creditCardDto) {
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
		this.creditCardDto = creditCardDto;
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
