package com.example.demo.model;

public class CustomerModel {

	private Long accountNo;
	private String name;
	private String accountType;
	private Double amount;
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
