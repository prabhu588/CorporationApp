package com.example.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.data.Message;
import com.example.exception.RecordNotFoundException;
import com.example.service.BillerService;

@RestController
public class BillerResource {


@Autowired
BillerService billservice;
	
@Autowired
Message msg;

@GetMapping(value="paybill",produces="json")
public Message payBill(@RequestParam String email ) throws RecordNotFoundException	{
	String response= billservice.payBill(email);
	
	
	if(response.equals("SUCCESS"))
		msg.setMessage("Your payment succesfully received");
	else
		msg.setMessage("Payment failed please try");
	
	return msg;
	
	
	
}

}
