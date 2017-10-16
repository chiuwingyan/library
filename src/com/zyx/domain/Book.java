package com.zyx.domain;

public class Book {
private Integer id;
private String isbn;
private String bookname;
private Integer count;
private String publish;
private String booktype;
private String author;
public Book() {
	super();
	// TODO Auto-generated constructor stub
}

public Book(String isbn, String bookname, Integer count, String publish, String booktype, String author) {
	super();
	this.isbn = isbn;
	this.bookname = bookname;
	this.count = count;
	this.publish = publish;
	this.booktype = booktype;
	this.author = author;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public String getPublish() {
	return publish;
}
public void setPublish(String publish) {
	this.publish = publish;
}
public String getBooktype() {
	return booktype;
}
public void setBooktype(String booktype) {
	this.booktype = booktype;
}
@Override
public String toString() {
	return "Book [id=" + id + ", isbn=" + isbn + ", bookname=" + bookname + ", count=" + count + ", publish=" + publish
			+ ", booktype=" + booktype + "]";
}

}
