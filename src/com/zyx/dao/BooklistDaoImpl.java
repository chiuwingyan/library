package com.zyx.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.zyx.domain.Admin;
import com.zyx.domain.Book;
import com.zyx.domain.Booktype;
import com.zyx.domain.PageBean;

@Repository(value = "booklistDao")
public class BooklistDaoImpl extends HibernateDaoSupport implements BooklistDao {

	@Autowired
	public void setSessionFactory0(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 分页查询
	 * @param mCurrentPage
	 * @param pageSize
	 * @param criteria
     * @return
     */
	public PageBean<Book> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria) {
		PageBean<Book> pageBean = new PageBean<>();
		pageBean.setPageCode(mCurrentPage);
		pageBean.setPageSize(pageSize);
		criteria.setProjection(Projections.rowCount());
		
		List<Number> list = (List<Number>) getHibernateTemplate().findByCriteria(criteria);

		if (list != null&&list.size()>0) {
			int totalCount = list.get(0).intValue();
			pageBean.setTotalCount(totalCount);
		}

		criteria.setProjection(null);
		List<Book> customerList = (List<Book>) getHibernateTemplate().findByCriteria(criteria,(mCurrentPage-1)*pageSize,pageSize);
		pageBean.setBeanList(customerList);
		return pageBean;
	}

	@Override
	public void save(Book book) {
		this.getHibernateTemplate().save(book);
	}

	@Override
	public List<Booktype> btlist() {
		List<Booktype> list = (List<Booktype>) getHibernateTemplate()
				.find("from Booktype");
		return list;
	}

	@Override
	public boolean findisbn(String isbn) {
	   List <Book> book=(List<Book>) getHibernateTemplate().find("from Book where isbn=?",isbn);
	   if(book!=null&&book.size()>0){
		   return false;
	   }
	   else
		   return true;
	}

	@Override
	public void delete(Book book) {
	 
		this.getHibernateTemplate().delete(book);
	}

	@Override
	public Book findbyid(Integer id) {
		return (Book)this.getHibernateTemplate().get(Book.class,id);
	}

	@Override
	public boolean findbook(Integer id, String isbn) {
		// TODO Auto-generated method stub
		List <Book> book=(List<Book>)getHibernateTemplate().find("from Book where isbn=? and id!=?",isbn,id);
		if(book!=null&&book.size()>0){
			return false;
		}else
			return true;
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(book);
	}

	
		
	}
	
	

