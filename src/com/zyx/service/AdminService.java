package com.zyx.service;

import com.zyx.domain.Admin;

public interface AdminService {
	public void changepassowrd(String username,String npsw);
	public boolean login(Admin admin);
}
