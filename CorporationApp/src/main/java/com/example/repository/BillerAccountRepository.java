package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AccountEntity;
import com.example.entity.BillerAccountEntity;

public interface BillerAccountRepository extends JpaRepository<BillerAccountEntity, Integer> {

}
