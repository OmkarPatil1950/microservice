package com.example.demo.DTO;

import org.hibernate.validator.constraints.UniqueElements;

import com.example.demo.entity.UserDetails;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {

	@NotBlank(message = "Name cannot be blank")
	private String name;

	@Column(nullable = false, unique = true, length = 255)
	@NotBlank(message = "Email cannot be blank")
	@Size(max = 255, message = "Email must be less than 255 characters")
	@Email(message = "Email should be valid")
	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
	private String email;

	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 8, message = "Password must be more than 8 characters")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]+$", message = "Password must contain at least one digit, one letter, and one special character")
	private String password;
	
	@Size(min = 10, max = 10, message = "Contact number must be exactly 10 digits")
	@Pattern(regexp = "^\\d{10}$", message = "Contact number must be numeric and exactly 10 digits")
	@Column(length = 10)
	private String contact;

	private UserDetails userdetails;

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", password=" + password + ", contact=" + contact
				+ ", userdetails=" + userdetails + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(@NotBlank(message = "Name cannot be blank") String name,
			@NotBlank(message = "Email cannot be blank") @Size(max = 255, message = "Email must be less than 255 characters") @Email(message = "Email should be valid") @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") String email,
			@NotEmpty(message = "Password cannot be empty") @Size(min = 8, message = "Password must be more than 8 characters") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]+$", message = "Password must contain at least one digit, one letter, and one special character") String password,
			@Size(min = 10, max = 10, message = "Contact number must be exactly 10 digits") @Pattern(regexp = "^\\d{10}$", message = "Contact number must be numeric and exactly 10 digits") String contact,
			UserDetails userdetails) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.userdetails = userdetails;
	}

	

}
