package com.zyx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyx.dao.AdminDao;
import com.zyx.dao.BooklistDao;
import com.zyx.domain.Admin;
import com.zyx.domain.Book;
import com.zyx.domain.Booktype;
import com.zyx.domain.PageBean;
@Service("booklistService")
@Transactional
public class BooklistServiceImpl implements BooklistService {
	
	@Autowired
	@Qualifier("booklistDao")
	private BooklistDao booklistDao;
	@Override
	public PageBean<Book> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return booklistDao.findByPage(mCurrentPage,pageSize,criteria);
	}
	@Override
	public boolean save(Book book) {
		// TODO Auto-generated method stub
		boolean i=booklistDao.findisbn(book.getIsbn());
		if(i){
		booklistDao.save(book);
		return true;
		}
		else
			return false;
	}
	@Override
	public List<Booktype> btlist() {
		List<Booktype> list=booklistDao.btlist();
		return list;
	}
	
	public void delete(Book book) {
	booklistDao.delete(book);
		
	}
	@Override
	public Book findById(Integer id) {
		return booklistDao.findbyid(id);
	}
	@Override
	public boolean findbook(Integer id, String isbn) {
		
		return booklistDao.findbook(id, isbn);
	}
	@Override
	public void update(Book book) {
		booklistDao.update(book);
		
	}

	
	}


