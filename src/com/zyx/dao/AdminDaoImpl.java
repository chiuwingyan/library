package com.zyx.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zyx.domain.Admin;


@Repository(value="adminDao")
public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	public int login(Admin admin) {
		// TODO Auto-generated method stub
		System.out.println("持久层");
		//save是新增啊bb仔
		//this.getHibernateTemplate().save(admin);
	List<Admin> list = (List<Admin>) getHibernateTemplate()
			.find("from Admin where username = ? and password = ?", 
			admin.getUsername(),admin.getPassword());
	if(list!=null&&list.size()>0){

		return 1;
	}else{
		return 0;
	}
	
	}

	

	@Override
	public void changpassoword(String username,String npsw) {
		String hql = "update Admin " +
				"set password=?" +
				" where username=?";
				getHibernateTemplate().bulkUpdate(hql,npsw,username);
	}

}
