package com.zyx.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zyx.dao.AdminDao;
import com.zyx.domain.Admin;

@Component(value="adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	
	@Resource(name="adminDao")
	private AdminDao adminDao;
	public boolean login(Admin admin) {
		// TODO Auto-generated method stub
		
		System.out.println("业务层登录");
		int i=adminDao.login(admin);
		if(i==1){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public void changepassowrd(String username, String npsw) {
		adminDao.changpassoword(username, npsw);
		
	}

}
