package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="BillerAccount")
public class BillerAccountEntity {

	
	@Column(name="balance")
	private Double balance;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="biller_id")
	private AccountEntity accountentity;

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public AccountEntity getAccountentity() {
		return accountentity;
	}

	public void setAccountentity(AccountEntity accountentity) {
		this.accountentity = accountentity;
	}
	
	


}
