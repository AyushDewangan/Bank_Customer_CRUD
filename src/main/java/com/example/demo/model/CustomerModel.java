package com.example.demo.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class CustomerModel {

	@Id
	private Long accountNo;
	@NotNull
	private String name;
	@NotNull
	private String accountType;
	@NotNull
	private Double amount;
	@NotNull
	private Long contact;

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

}
