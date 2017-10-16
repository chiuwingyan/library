package com.zyx.service;

import org.hibernate.criterion.DetachedCriteria;

import com.zyx.domain.Black;
import com.zyx.domain.Book;
import com.zyx.domain.PageBean;

public interface BlackService {
	public Black findById(Integer id) ;
	public void delete(Black black);
	public boolean save(Black black);
	public boolean findblack(Integer id, String stu_id);
	public void update(Black black);
	PageBean<Black> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria);
}
