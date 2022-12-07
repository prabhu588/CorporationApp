package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.data.Message;
import com.example.entity.BillerAccountEntity;
import com.example.entity.BillersEntity;
import com.example.entity.CustomerEntity;
import com.example.exception.RecordNotFoundException;
import com.example.repository.BillerRepository;

@Service
public class BillerService {

	@Autowired
	BillerRepository billerepository;
	
	@Autowired
	CustomerService custservice;
	
	@Autowired
	PaymentService paymentservice;
	
	public String payBill(String emailid) throws RecordNotFoundException
	{
		String response="";
		CustomerEntity customer= custservice.getCustomerByEmailId(emailid);
		
		BillersEntity biller= getBillerAccount(customer.getCustbillerid());
		
		synchronized (biller) {
		 response=	paymentservice.doPayment(biller,customer);
		}
		return response;
		
	}
	
	
	public BillersEntity getBillerAccount(Integer billerid) throws RecordNotFoundException
	{
		Optional<BillersEntity> biller=billerepository.findById(billerid);
		
		 if(biller.isPresent()) {
	          return biller.get();
	      } else {
	          throw new RecordNotFoundException("No  record exist for given biller id "+billerid);
	      }
		
	}
	
}
