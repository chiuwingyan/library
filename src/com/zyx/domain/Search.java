package com.zyx.domain;

public class Search {
	private String search;
	private String key;
	public Search(String search, String key) {
		super();
		this.search = search;
		this.key = key;
	}
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key= key;
	}
	
	
}
