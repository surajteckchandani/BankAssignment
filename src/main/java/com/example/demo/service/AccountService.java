package com.example.demo.service;

import com.example.demo.entity.Account;

public interface AccountService {
	
	void save(Account userForm);
	Account getBalance(String username);
	Account getAccountDetails(String username);

}
