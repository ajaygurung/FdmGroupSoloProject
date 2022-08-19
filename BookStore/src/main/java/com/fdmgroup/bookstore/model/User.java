package com.fdmgroup.bookstore.model;

import java.util.List;
import java.util.Objects;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String emial;
	private List<Order> orders;
	
	public User(int userId, String firstName, String lastName, String userName, String password, String emial,
			List<Order> orders) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.emial = emial;
		this.orders = orders;
	}

	public User() {
		super();
	}

	

	public User(String firstName, String lastName, String userName, String password, String emial) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.emial = emial;
	}

	public User(int userId, String firstName, String lastName, String userName, String password, String emial) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.emial = emial;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(emial, firstName, lastName, orders, password, userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(emial, other.emial) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(orders, other.orders)
				&& Objects.equals(password, other.password) && userId == other.userId
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", emial=" + emial + ", orders=" + orders + "]";
	}
	
	
}
