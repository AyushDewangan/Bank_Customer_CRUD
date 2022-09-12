package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class MyUser {

	@Id
	@Column
	private int id;
	@NotBlank
	private String name;
	@NotBlank
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MyRole> role;

	public List<MyRole> getRole() {
		return role;
	}

	public void setRole(List<MyRole> role) {
		this.role = role;
	}


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
		return "MyUser [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
