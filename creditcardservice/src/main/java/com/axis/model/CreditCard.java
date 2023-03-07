package com.axis.model;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "creditCards50")
public class CreditCard implements Serializable {

	@Id
	@Column(name = "creditCard_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	
	@OneToOne(mappedBy = "creditCard", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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
	public CreditCard(int id, long cardNumber, String holderName, long accountNo, String branchName, String bank,
			String cardType, double balance, Date expireDate, int cvv, Double dailyLimit, Boolean status,
			User user) {
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
		this.user = user;
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
