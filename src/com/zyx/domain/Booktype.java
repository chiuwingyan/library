package com.zyx.domain;

public class Booktype {
	private Integer id;
	private String booktype;
	
	public Booktype() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Booktype(String booktype) {
		super();
		this.booktype = booktype;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	
}
