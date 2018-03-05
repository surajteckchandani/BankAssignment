package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;
@Service
@Transactional
public class TransactionServiceImpl  implements TransactionServce{
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public void save(Transaction userForm) {
		// TODO Auto-generated method stub
		transactionRepository.save(userForm);
		
	}

}
