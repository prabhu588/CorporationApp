package com.example.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="AccountHistory")
public class AccountHistoryEntity {

	@Id 
	@Column(name="transaction_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transactionid;
	
	@Column(name="paid_amt")
	private Double paidamt;
	
	@Column(name="paid_dt")
	 @DateTimeFormat(pattern = "dd-MM-yyyy")
	 @Temporal(TemporalType.TIMESTAMP)
	private Date paiddt;
	
	@Column(name="wallet_biller_id")
	private Integer walletbillerid;
	

	public Long getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}

	public Double getPaidamt() {
		return paidamt;
	}

	public void setPaidamt(Double paidamt) {
		this.paidamt = paidamt;
	}

	public Date getPaiddt() {
		return paiddt;
	}

	public void setPaiddt(Date paiddt) {
		this.paiddt = paiddt;
	}

	public Integer getWalletbillerid() {
		return walletbillerid;
	}

	public void setWalletbillerid(Integer walletbillerid) {
		this.walletbillerid = walletbillerid;
	}

	@Override
	public String toString() {
		return "AccountHistoryEntity [transactionid=" + transactionid + ", paidamt=" + paidamt + ", paiddt=" + paiddt
				+ ", walletbillerid=" + walletbillerid + "]";
	}


}
