package com.zyx.domain;

public class Admin {
private Integer id;

private String password;
private String username;

public Admin(String username,String password) {
	super();
	this.username = username;
	
	this.password = password;
}
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
@Override
public String toString() {
	return "Admin [id=" + id + ", username=" + username + ", password=" + password + "]";
}

}
