package com.axis.model;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "creditCards50")
public class CreditCard implements Serializable {

	@Id
	private ObjectId id;
	private long cardNumber;
	private String holderName;
	private String cardType;
	private double balance;
	private long accountNo;
	private String branchName;
	private String bank;
	private Date expireDate;
	private int cvv;
	private Double dailyLimit;
	private Boolean status;
	
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CreditCard() {
		super();
		
	}
	public CreditCard(ObjectId id, long cardNumber, String holderName, String cardType, double balance, long accountNo,
			String branchName, String bank, Date expireDate, int cvv, Double dailyLimit, Boolean status, User user) {
		super();
		this.id = id;
		this.cardNumber = cardNumber;
		this.holderName = holderName;
		this.cardType = cardType;
		this.balance = balance;
		this.accountNo = accountNo;
		this.branchName = branchName;
		this.bank = bank;
		this.expireDate = expireDate;
		this.cvv = cvv;
		this.dailyLimit = dailyLimit;
		this.status = status;
		this.user = user;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
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
