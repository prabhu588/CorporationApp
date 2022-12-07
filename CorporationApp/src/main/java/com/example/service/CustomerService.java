package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AccountEntity;
import com.example.entity.CustomerEntity;
import com.example.exception.InvalidUserDataException;
import com.example.exception.RecordNotFoundException;
import com.example.repository.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custrepository;
	
	  public CustomerEntity createOrUpdateCustomer(CustomerEntity entity,Double balance) throws InvalidUserDataException
	    { 
	        Optional<CustomerEntity> customer = custrepository.findById(entity.getEmailid());
	        if(customer.isPresent())
	        {
	        	CustomerEntity newEntity = customer.get();
	        	newEntity.setEmailid(entity.getEmailid());
	        	
	        	newEntity.setAccount(new AccountEntity(balance));
	 
	            newEntity = custrepository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = custrepository.save(entity);
	             
	            return entity;
	        }
	    }
	  public CustomerEntity getCustomerByEmailId(String emailid) throws RecordNotFoundException
	  {
	      Optional<CustomerEntity> customer = custrepository.findById(emailid);
	       
	      if(customer.isPresent()) {
	          return customer.get();
	      } else {
	          throw new RecordNotFoundException("No account record exist for given email id "+emailid);
	      }
	  }
	     
}
