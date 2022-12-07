package com.example.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.CustomerEntity;
import com.example.exception.InvalidUserDataException;
import com.example.exception.RecordNotFoundException;
import com.example.service.CustomerService;

@RestController()
@RequestMapping("/customer")
public class CustomerResource {

@Autowired
CustomerService cusservice;
	
@PostMapping(value="customer/{balance}")	
public ResponseEntity<CustomerEntity> registerOrUpdateCustommerAccount(@RequestBody CustomerEntity customer,Double balance) throws InvalidUserDataException	{
	
	CustomerEntity updated = cusservice.createOrUpdateCustomer(customer, balance);
    return new ResponseEntity<CustomerEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	
}

@GetMapping(value="customer/")
public ResponseEntity<CustomerEntity> getCustomerByEmailId(@RequestParam String emailid) throws RecordNotFoundException
{
	CustomerEntity customer= cusservice.getCustomerByEmailId(emailid);
    return new ResponseEntity<CustomerEntity>(customer, new HttpHeaders(), HttpStatus.OK);
}




	
}
