package com.example.crud.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	
	@Id
	private int id;
	private int age;
	private String name;
	private String address;
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", name=" + name + ", address=" + address + "]";
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
	

}
