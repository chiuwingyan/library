package com.zyx.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.zyx.domain.Black;
import com.zyx.domain.Book;
import com.zyx.domain.PageBean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository(value = "blackDao")
public class BlackDaoImpl extends HibernateDaoSupport implements BlackDao {

	
	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public PageBean<Black> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Black> pageBean = new PageBean<>();
		pageBean.setPageCode(mCurrentPage);
		pageBean.setPageSize(pageSize);
		criteria.setProjection(Projections.rowCount());
		
		List<Number> list = (List<Number>) getHibernateTemplate().findByCriteria(criteria);
		
		if (list != null&&list.size()>0) {
			int totalCount = list.get(0).intValue();
			pageBean.setTotalCount(totalCount);
		}

		criteria.setProjection(null);
		List<Black> customerList = (List<Black>) getHibernateTemplate().findByCriteria(criteria,(mCurrentPage-1)*pageSize,pageSize);
		pageBean.setBeanList(customerList);
		return pageBean;
	}

	@Override
	public Black findById(Integer id) {
		// TODO Auto-generated method stub
		return (Black)this.getHibernateTemplate().get(Black.class,id);
	}

	@Override
	public void delete(Black black) {
		this.getHibernateTemplate().delete(black);
		
	}

	@Override
	public void save(Black black) {
		this.getHibernateTemplate().save(black);
		
	}

	@Override
	public boolean findstu_id(String stu_id) {
		 List <Black> black=(List<Black>) getHibernateTemplate().find("from Black where stu_id=?",stu_id);
		   if(black!=null&&black.size()>0){
			   return false;
		   }
		   else
			   return true;
	}

	@Override
	public boolean findblack(Integer id, String stu_id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				List <Black> black=(List<Black>)getHibernateTemplate().find("from Black where stu_id=? and id!=?",stu_id,id);
				if(black!=null&&black.size()>0){
					return false;
				}else
					return true;
	}

	@Override
	public void update(Black black) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(black);
	}

	

	
	

}
