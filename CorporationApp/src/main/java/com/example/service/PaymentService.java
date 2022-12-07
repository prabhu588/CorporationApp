package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.Message;
import com.example.entity.AccountEntity;
import com.example.entity.AccountHistoryEntity;
import com.example.entity.BillerAccountEntity;
import com.example.entity.BillersEntity;
import com.example.entity.CustomerEntity;
import com.example.exception.NotSufficentFundException;
import com.example.repository.AccountHistoryRepository;
import com.example.repository.AccountRepository;
import com.example.repository.BillerAccountRepository;
import com.example.repository.BillerRepository;

@Service
public class PaymentService {

	
	@Autowired
	BillerRepository billrepository;
	
	@Autowired
	BillerAccountRepository billeraccountrepository;
	
	@Autowired
	AccountRepository accrepository;
	
	@Autowired
	AccountHistoryEntity accounthistoryentity;
	
	@Autowired
	AccountHistoryRepository acchisrepository;
	
	public String doPayment(BillersEntity billerentity,CustomerEntity custentity) throws NotSufficentFundException
	{
		String response="FAIL";
	Double billamt=billrepository.getBalanceAmount(billerentity.getBillerid());
	
	Double custbalance=custentity.getAccount().getBalance();
	
	if(custbalance>billamt)
	{	//updating balance in biller account
		BillerAccountEntity billeraccountentitty=billerentity.getBilleracccount();
		billeraccountentitty.setBalance(billeraccountentitty.getBalance()+billamt);
		
		//update customer walletbalance
		AccountEntity accentity=custentity.getAccount();
		accentity.setBalance(accentity.getBalance()-billamt);
		
		
		billeraccountrepository.save(billeraccountentitty);
		accrepository.save(accentity);
		
		//insert record for transaction
		accounthistoryentity.setPaidamt(billamt);
		accounthistoryentity.setPaiddt(new Date());
		accounthistoryentity.setWalletbillerid(billerentity.getBillerid());
		
		acchisrepository.save(accounthistoryentity);
		 response="SUCCESS";
		 return response;
	}
	else {
		
		throw new NotSufficentFundException("Not suffiend fund");
	}
	
	}
	
	
}
