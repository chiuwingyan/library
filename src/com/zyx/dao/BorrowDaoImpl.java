package com.zyx.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.zyx.domain.Admin;
import com.zyx.domain.Book;
import com.zyx.domain.Borrow;
import com.zyx.domain.PageBean;
@Repository(value = "borrowDao")
public class BorrowDaoImpl extends HibernateDaoSupport implements BorrowDao {

	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public List<Book> findallisbn() {
		
		return (List<Book>)this.getHibernateTemplate().find("from Book");

		
	}

	@Override
	public PageBean<Borrow> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Borrow> pageBean = new PageBean<>();
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
		List<Borrow> customerList = (List<Borrow>) getHibernateTemplate().findByCriteria(criteria,(mCurrentPage-1)*pageSize,pageSize);
		pageBean.setBeanList(customerList);
		return pageBean;
		
//		return null;
		
	}

	@Override
	public Integer findcount(String isbn) {
		List<Book> list = (List<Book>) getHibernateTemplate()
				.find("from Book where isbn = ?", 
				isbn);
		return list.get(0).getCount();
	}

	@Override
	public void save(Borrow borrow) {
		this.getHibernateTemplate().save(borrow);
		
	}

	@Override
	public int findbar(String bar) {
		List<Borrow> list = (List<Borrow>) getHibernateTemplate()
				.find("from Borrow where bar = ?", 
				bar);
		if(list!=null&&list.size()>0){

			return 1;
		}else{
			return 0;
		}
		
		
	}

	@Override
	public void countjian(String isbn) {
		List <Book> booklist=(List<Book>) getHibernateTemplate().find("from Book where isbn=?",isbn);
		Book book=booklist.get(0);
		book.setCount(book.getCount()-1);
		getHibernateTemplate().update(book);
		
	}
	

}
