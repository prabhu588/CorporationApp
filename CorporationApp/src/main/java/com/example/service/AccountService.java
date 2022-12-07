package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AccountEntity;
import com.example.exception.RecordNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.CustomerRepository;

@Service
public class AccountService {

	
@Autowired
AccountRepository accrepository;

@Autowired
CustomerRepository custrepository;

public List<AccountEntity> getAllAccounts()
{
    List<AccountEntity> employeeList = accrepository.findAll();
     
    if(employeeList.size() > 0) {
        return employeeList;
    } else {
        return new ArrayList<AccountEntity>();
    }
}
 
public AccountEntity getBalanceById(Integer id) throws RecordNotFoundException
{
    Optional<AccountEntity> employee = accrepository.findById(id);
     
    if(employee.isPresent()) {
        return employee.get();
    } else {
        throw new RecordNotFoundException("No account record exist for given id "+id);
    }
}
}
