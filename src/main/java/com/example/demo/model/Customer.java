package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountNo;
	@Column

	private String name;
	@Column

	private String accountType;
	@Column

	private Double amount;
	@Column

	private Long contact;

	public Long getAccount_no() {
		return accountNo;
	}

	public void setAccount_no(Long account_no) {
		this.accountNo = account_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount_type() {
		return accountType;
	}

	public void setAccount_type(String account_type) {
		this.accountType = account_type;
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
