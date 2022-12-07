package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.BillersEntity;

@Repository
public interface BillerRepository extends JpaRepository<BillersEntity, Integer> {

	@Query("select sum(b.bill_amt) from Billers b where b.billstatus='N'")
	public Double getBalanceAmount(Integer id);
	
}
