package com.zyx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zyx.domain.Admin;
import com.zyx.domain.Book;
import com.zyx.domain.PageBean;
import com.zyx.domain.*;

public interface BooklistService {
	public boolean save(Book book);
	public List<Booktype> btlist();
	public void delete(Book book);
	public Book findById(Integer id);
	public boolean findbook(Integer id,String isbn);
	public void update(Book book);
	PageBean<Book> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria);
}
