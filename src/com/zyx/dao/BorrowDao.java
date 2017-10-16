package com.zyx.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zyx.domain.Book;
import com.zyx.domain.Borrow;
import com.zyx.domain.PageBean;

public interface BorrowDao {
	public List<Book> findallisbn() ;
	public PageBean<Borrow> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria);
	public Integer findcount(String isbn);
	public void save(Borrow borrow);
	public int findbar(String bar);
	public void countjian(String isbn);
	
}
