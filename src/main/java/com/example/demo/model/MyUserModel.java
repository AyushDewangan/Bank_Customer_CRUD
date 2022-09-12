package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

public class MyUserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String name;
	@NotBlank
	private String password;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MyRoleModel> roleModel;

	public List<MyRoleModel> getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(List<MyRoleModel> roleModel) {
		this.roleModel = roleModel;
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
		return "MyUserModel [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
