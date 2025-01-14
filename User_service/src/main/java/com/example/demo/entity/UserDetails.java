package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


 
@Table(name = "userDetails")
@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userdetailsId;
	private String gender;
	private int age;

	private String address;
	private int pincode;
	
	@OneToOne
	@JsonBackReference
	private User users;
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(int userdetailsId, String gender, int age, String address, int pincode, User users) {
		super();
		this.userdetailsId = userdetailsId;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.pincode = pincode;
		this.users = users;
	}

	public int getUserdetailsId() {
		return userdetailsId;
	}

	public void setUserdetailsId(int userdetailsId) {
		this.userdetailsId = userdetailsId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserDetails [userdetailsId=" + userdetailsId + ", gender=" + gender + ", age=" + age + ", address="
				+ address + ", pincode=" + pincode + ", users=" + users + "]";
	}

}
