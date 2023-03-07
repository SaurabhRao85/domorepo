package com.axis.dto;

import java.util.Date;
import java.util.Set;

public class CreditCardDto {

	private int id;
	private long cardNumber;
	private String holderName;
	private long accountNo;
	private String branchName;
	private String bank;
	private String cardType;
	private double balance;
	private Date expireDate;
	private int cvv;
	private Double dailyLimit;
	private Boolean status;
	
	private UserDto userDto;
	
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public CreditCardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreditCardDto(int id, long cardNumber, String holderName, long accountNo, String branchName, String bank,
			String cardType, double balance, Date expireDate, int cvv, Double dailyLimit, Boolean status,
			UserDto userDto) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.holderName = holderName;
		this.accountNo = accountNo;
		this.branchName = branchName;
		this.bank = bank;
		this.cardType = cardType;
		this.balance = balance;
		this.expireDate = expireDate;
		this.cvv = cvv;
		this.dailyLimit = dailyLimit;
		this.status = status;
		this.userDto = userDto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public Double getDailyLimit() {
		return dailyLimit;
	}
	public void setDailyLimit(Double dailyLimit) {
		this.dailyLimit = dailyLimit;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
