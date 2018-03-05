package com.example.demo.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Account;
import com.example.demo.entity.CustomError;
import com.example.demo.entity.Transaction;
import com.example.demo.entity.TransactionType;
import com.example.demo.service.AccountService;
import com.example.demo.service.TransactionServce;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionServce transactionServce;
	
	
	
	
	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public ResponseEntity<?> getLongUrl(@RequestBody Account account) {
		try {
			Account acc=accountService.getBalance(account.getUsername());
			if(acc==null) {
			account.setBalance(new Integer(0));
			account.setEnabled(true);
			account.setDeleted(false);
			account.setOpening_date(new Date());
			accountService.save(account);
			return new ResponseEntity<Object>("Account created successfully", HttpStatus.CREATED);
			}else {
				CustomError customError= new CustomError();
				customError.setMessage("Username already exist");
				customError.setStatuscode(500);
				
				return new ResponseEntity<Object>(customError, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch (Exception e) {
			// TODO: handle exception
			CustomError customError= new CustomError();
			customError.setMessage("unable to create account");
			customError.setStatuscode(500);
			 Set<String> errors = new HashSet<String>(0);
			 errors.add(e.getMessage());
			 customError.setErrors(errors);
			return new ResponseEntity<Object>(customError, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "/getBalance", method = RequestMethod.POST)
	public ResponseEntity<?> getBalance(@RequestBody Account account) {
		if(account.getUsername()!=null ) {
			Account acc=accountService.getBalance(account.getUsername());
					if(acc!=null) {
						return new ResponseEntity<Object>("Your current balance is="+acc.getBalance(), HttpStatus.OK);
					}else {
						CustomError err=new CustomError();
						err.setMessage("account with this username '"+account.getUsername()+"' dose not exist");
						err.setStatuscode(404);
						return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
					}
		}else {
			CustomError err=new CustomError();
			err.setMessage("Please provide some username ");
			err.setStatuscode(404);
			return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
		}
		
	}

	@RequestMapping(value = "/addAmount/{username}", method = RequestMethod.POST)
	public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction,@PathVariable String username) {
		if(transaction!=null &&  username!=null) {
			Account acc=accountService.getBalance(username);
			transaction.setType("CREDIT");
			transaction.setStatus("Successfull");
			transaction.setTransaction_date(new Date());
			try {
				transactionServce.save(transaction);
			}catch (Exception e) {
				// TODO: handle exception
				transaction.setStatus("UnSuccessfull");
				transactionServce.save(transaction);
			}
			 Set<Transaction> set = new HashSet<Transaction>(0);
			 set.add(transaction);
			acc.setTransaction(set);
			float newBal=acc.getBalance()+transaction.getAmount();
			acc.setBalance(newBal);
			accountService.save(acc);
			return new ResponseEntity<Object>("Your current balance is="+newBal, HttpStatus.OK);
		}
		return null;
	}
	
	@RequestMapping(value = "/withdrawAmount/{username}", method = RequestMethod.POST)
	public ResponseEntity<?> withdrawAmount(@RequestBody Transaction transaction,@PathVariable String username) {
		if(transaction.getAmount()!=0) {
			Account acc=accountService.getBalance(username);
			if(acc.getBalance()<transaction.getAmount()) {
				CustomError err= new CustomError();
				err.setMessage("you dont have sufficent balance");
				err.setStatuscode(403);
				return new ResponseEntity<Object>(err, HttpStatus.FORBIDDEN);
			}else {
				transaction.setTransaction_date(new Date());
				transaction.setType("DEBIT");
				transaction.setStatus("Successfull");
				try {
					transactionServce.save(transaction);
				}catch (Exception e) {
					// TODO: handle exception
					transaction.setStatus("UnSuccessfull");
					transactionServce.save(transaction);
				}
				 Set<Transaction> set = new HashSet<Transaction>(0);
				 set.add(transaction);
				acc.setTransaction(set);
				float newBal=acc.getBalance()-transaction.getAmount();
				acc.setBalance(newBal);
				accountService.save(acc);
				return new ResponseEntity<Object>("Your current balance is="+newBal, HttpStatus.OK);
			}
			
		}else {
			CustomError err= new CustomError();
			err.setMessage("Please enter some Amount");
			err.setStatuscode(404);
			return new ResponseEntity<Object>(err, HttpStatus.NOT_FOUND);
		}
	}
}
