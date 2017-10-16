package com.zyx.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zyx.domain.Back;
import com.zyx.domain.Book;
import com.zyx.domain.Borrow;
import com.zyx.domain.PageBean;
@Repository(value = "backDao")
public class BackDaoImpl extends HibernateDaoSupport implements BackDao{

	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	public PageBean<Back> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Back> pageBean = new PageBean<>();
		pageBean.setPageCode(mCurrentPage);
		pageBean.setPageSize(pageSize);
		criteria.setProjection(Projections.rowCount());
		
		List<Number> list = (List<Number>) getHibernateTemplate().findByCriteria(criteria);

		if (list != null&&list.size()>0) {
			int totalCount = list.get(0).intValue();
			pageBean.setTotalCount(totalCount);
		}

		criteria.setProjection(null);
		@SuppressWarnings("unchecked")
		List<Back> customerList = (List<Back>) getHibernateTemplate().findByCriteria(criteria,(mCurrentPage-1)*pageSize,pageSize);
		pageBean.setBeanList(customerList);
		return pageBean;
		
//		return null;
		
	}

	@Override
	public List<Book> findallisbn() {
		// TODO Auto-generated method stub
		return (List<Book>)this.getHibernateTemplate().find("from Book");
	}

	@Override
	public boolean findbar(String bar) {
		List<Borrow> list = (List<Borrow>) getHibernateTemplate()
				.find("from Borrow where bar = ?", 
				bar);
		if (list != null&&list.size()>0) {
			return true;
		}else
			return false;
	}

	@Override
	public void jiacount(String isbn) {
		// TODO Auto-generated method stub
		List <Book> booklist=(List<Book>) getHibernateTemplate().find("from Book where isbn=?",isbn);
		Book book=booklist.get(0);
		book.setCount(book.getCount()+1);
		getHibernateTemplate().update(book);
	}

	@Override
	public void deleteborrow(String bar) {
		List<Borrow> list = (List<Borrow>) getHibernateTemplate()
				.find("from Borrow where bar = ?", 
				bar);
		Borrow borrow=list.get(0);
		this.getHibernateTemplate().delete(borrow);
		
	}

	@Override
	public void addback(Back back) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(back);
	}
}
