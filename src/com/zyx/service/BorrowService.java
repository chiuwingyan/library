package com.zyx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zyx.domain.Book;
import com.zyx.domain.Borrow;
import com.zyx.domain.PageBean;

public interface BorrowService {
	public List<Book> findallisbn();
	public PageBean<Borrow> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria);
	public int add(Borrow borrow);

}
