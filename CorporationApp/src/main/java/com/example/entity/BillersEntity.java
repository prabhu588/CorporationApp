package com.example.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Billers")
public class BillersEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="biller_id")
	private Integer billerid;
	
	@Column(name="bill_amt")
	private Double billamt;
	
	@Column(name="bill_period")
	private  String billperiod;
	
	@Column(name="bill_status")
	private char billstatus;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="biiler_id")
	private BillerAccountEntity billeracccount;
	
	public Integer getBillerid() {
		return billerid;
	}

	public void setBillerid(Integer billerid) {
		this.billerid = billerid;
	}

	public Double getBillamt() {
		return billamt;
	}

	public void setBillamt(Double billamt) {
		this.billamt = billamt;
	}

	public String getBillperiod() {
		return billperiod;
	}

	public void setBillperiod(String billperiod) {
		this.billperiod = billperiod;
	}

	public char getBillstatus() {
		return billstatus;
	}

	public void setBillstatus(char billstatus) {
		this.billstatus = billstatus;
	}

	public BillerAccountEntity getBilleracccount() {
		return billeracccount;
	}

	public void setBilleracccount(BillerAccountEntity billeracccount) {
		this.billeracccount = billeracccount;
	}

	@Override
	public String toString() {
		return "BillersEntity [billerid=" + billerid + ", billamt=" + billamt + ", billperiod=" + billperiod
				+ ", billstatus=" + billstatus + ", billeracccount=" + billeracccount + "]";
	}

	
	
	
	

}
