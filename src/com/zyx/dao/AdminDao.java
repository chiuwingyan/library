package com.zyx.dao;

import com.zyx.domain.Admin;

public interface AdminDao {
	
	public void changpassoword(String username,String npsw);
	public int login(Admin admin);
}
