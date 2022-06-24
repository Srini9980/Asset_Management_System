package com.asm.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.checkerframework.common.aliasing.qual.Unique;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	@Unique
	@NotNull(message = "User name is required")
	@Column(name = "user_name")
	private String userName;
	@NotNull(message = "User email is required")
	@Column(name = "user_email")
	private String userEmail;
	@Column(name = "user_password")
	private String password;
	@NotNull(message = "User mobile is required")
	@Column(name = "user_mobile")
	private long userMobile;
	@Column(name = "user_address")
	private String userAddress;
	@NotNull(message = "User role is required")
	@Column(name = "user_role")
	private String userRole;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> order = new ArrayList<>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(long userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

}
