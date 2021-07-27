package com.ssafy.hellingers.service;

import com.ssafy.hellingers.model.Account;
import com.ssafy.hellingers.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;


    @Override
    public List<Account> selectAll() {
        return accountRepository.findAll();
    }
}