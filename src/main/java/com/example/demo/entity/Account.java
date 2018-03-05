package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "accountid")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize = 1)
    private Long accountid;

    @Column(name = "username", length = 50, unique = true)
    @NotNull
    private String username;

    @Column(name = "password", length = 100)
    @NotNull
    private String password;

    @Column(name = "type", length = 50)
    @NotNull
    private String type;

    @Column(name = "email", length = 50)
    @NotNull
    private String email;

    @Column(name = "enabled")
    @NotNull
    private Boolean enabled;

    @Column(name = "opening_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date opening_date;
    
    
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private AccountDetails accountDetails;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "account_transaction", joinColumns = { @JoinColumn(name = "accountid") }, inverseJoinColumns = { @JoinColumn(name = "transactionid") })
    private Set<Transaction> transaction = new HashSet<Transaction>(0);

    
    @Column(name = "deleted")
    @NotNull
    private Boolean deleted;
    
    @Column(name = "balance")
    @NotNull
    private float balance;


	public Long getAccountid() {
		return accountid;
	}


	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Date getOpening_date() {
		return opening_date;
	}


	public void setOpening_date(Date opening_date) {
		this.opening_date = opening_date;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	

	public AccountDetails getAccountDetails() {
		return accountDetails;
	}


	public void setAccountDetails(AccountDetails accountDetails) {
		this.accountDetails = accountDetails;
	}


	

	public Set<Transaction> getTransaction() {
		return transaction;
	}


	public void setTransaction(Set<Transaction> transaction) {
		this.transaction = transaction;
	}


	


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", username=" + username + ", password=" + password + ", type="
				+ type + ", email=" + email + ", enabled=" + enabled + ", opening_date=" + opening_date + ", deleted="
				+ deleted + "]";
	}

   
	
	
}