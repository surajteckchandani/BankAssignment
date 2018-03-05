package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Account;


public interface AccountRepository extends CrudRepository<Account, Long>  {
	
	
	@Query("SELECT u FROM Account u where u.username = :username and u.deleted = 0)")
	Account findByUsername(@Param("username") String username);
	
	@Query("SELECT u FROM Account u where u.email = :email and u.deleted = 0)")
	Account findByEmail(@Param("email") String email);

}
