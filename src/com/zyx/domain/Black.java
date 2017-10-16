package com.zyx.domain;

public class Black {
private Integer id;
private String stu_id;
private String stu_name;
public Black() {
	super();
	// TODO Auto-generated constructor stub
}

public Black(String stu_id, String stu_name) {
	super();
	this.stu_id = stu_id;
	this.stu_name = stu_name;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getStu_id() {
	return stu_id;
}
public void setStu_id(String stu_id) {
	this.stu_id = stu_id;
}
public String getStu_name() {
	return stu_name;
}
public void setStu_name(String stu_name) {
	this.stu_name = stu_name;
}

}
