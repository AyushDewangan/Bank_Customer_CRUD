package com.example.demo.model;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class MyUserModel {
	
	@Id
	private int id;
	@NotNull
	private String name;
	@NotNull
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "MyUserModel [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
