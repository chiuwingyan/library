package com.zyx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zyx.domain.Back;
import com.zyx.domain.Book;
import com.zyx.domain.Borrow;
import com.zyx.domain.PageBean;

public interface BackService {
	public List<Book> findallisbn();
	public PageBean<Back> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria);
	public boolean add(Back back);
}
