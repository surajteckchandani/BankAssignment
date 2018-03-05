package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.AccountDetails;


public interface AccountDetailsRepository  extends CrudRepository<AccountDetails, Long>{

}
