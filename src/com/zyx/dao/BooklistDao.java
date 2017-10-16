package com.zyx.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zyx.domain.Admin;
import com.zyx.domain.Book;
import com.zyx.domain.Booktype;
import com.zyx.domain.PageBean;

public interface BooklistDao {
	public void save(Book book);
	public List<Booktype> btlist();
	public boolean findisbn(String isbn);
	public void delete(Book book);
	public Book findbyid(Integer id);
	public boolean findbook(Integer id,String isbn);
	public void update(Book book);
	PageBean<Book> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria);
}
