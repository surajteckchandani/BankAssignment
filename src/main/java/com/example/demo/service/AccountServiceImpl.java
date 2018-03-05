package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	
	
	@Autowired
	private AccountRepository account;
	
	
	@Override
	public void save(Account userForm) {
		// TODO Auto-generated method stub
		account.save(userForm);

	}


	@Override
	public Account getBalance(String username) {
		// TODO Auto-generated method stub
		return account.findByUsername(username);
	}


	@Override
	public Account getAccountDetails(String username) {
		// TODO Auto-generated method stub
		return account.findByUsername(username);
	}

}
