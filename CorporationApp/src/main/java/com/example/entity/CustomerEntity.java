package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class CustomerEntity {

	@Id
	@Column(name="email_id")
	private String emailid;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="acc_id")
	private AccountEntity account;
	
	@Column(name="cust_biller_id")
	private Integer custbillerid;


	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}


	public AccountEntity getAccount() {
		return account;
	}


	public void setAccount(AccountEntity account) {
		this.account = account;
	}


	public Integer getCustbillerid() {
		return custbillerid;
	}


	public void setCustbillerid(Integer custbillerid) {
		this.custbillerid = custbillerid;
	}


	@Override
	public String toString() {
		return "CustomerEntity [emailid=" + emailid + ", account=" + account + ", custbillerid=" + custbillerid + "]";
	}


	

	
}
