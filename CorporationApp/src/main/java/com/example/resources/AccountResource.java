package com.example.resources;

import java.awt.PageAttributes.MediaType;
import java.util.Optional;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AccountEntity;
import com.example.entity.CustomerEntity;
import com.example.exception.InvalidUserDataException;
import com.example.exception.RecordNotFoundException;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;

@RestController
public class AccountResource {


	@Autowired 
	AccountService accservice;
	
	@GetMapping(value="accounts/{id}",produces="json")
	public Double getBalanceById(Integer id) throws  RecordNotFoundException	{
		
		AccountEntity acc = accservice.getBalanceById(id);
	    return acc.getBalance();
		
	}
}
