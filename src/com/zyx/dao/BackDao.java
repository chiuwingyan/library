package com.zyx.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zyx.domain.Back;
import com.zyx.domain.Book;
import com.zyx.domain.Borrow;
import com.zyx.domain.PageBean;

public interface BackDao {
	public PageBean<Back> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria);
	public List<Book> findallisbn();
	public boolean findbar(String bar);
	public void jiacount(String isbn);
	public void deleteborrow(String bar);
	public void addback(Back back);
}
