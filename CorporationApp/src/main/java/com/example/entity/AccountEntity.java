package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Account")
public class AccountEntity {
	
	@Id
	@Column(name="acc_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer accid;
	
	@Column(name="balance")
	private Double balance;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="Account")
	@JoinColumn(name="acc_id")
	private CustomerEntity customer;
	
	public AccountEntity(Double balance) {
		super();
		this.balance = balance;
	}
	public Integer getAccid() {
		return accid;
	}

	public void setAccid(Integer accid) {
		this.accid = accid;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "AccountEntity [accid=" + accid + ", balance=" + balance + ", customer=" + customer + "]";
	}
	
	
}
