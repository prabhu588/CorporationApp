package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AccountHistoryEntity;

public interface AccountHistoryRepository  extends JpaRepository<AccountHistoryEntity, Long>{

}
