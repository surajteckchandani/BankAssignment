package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "transaction")
public class Transaction {
	
	
	@Id
    @Column(name = "transactionid")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", allocationSize = 1)
    private Long transactionid;
	
	@Column(name = "type", length = 50)
    @NotNull
	private String type;
	
	@Column(name = "status", length = 50)
    @NotNull
	private String status;
	
	@Column(name = "amount", length = 50)
    @NotNull
	private float amount;
	
	
	 	@Column(name = "transaction_date")
	    @Temporal(TemporalType.TIMESTAMP)
	    @NotNull
	    private Date transaction_date;

	public Long getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(Long transactionid) {
		this.transactionid = transactionid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	
	
	

}
