package com.zyx.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.zyx.domain.Black;
import com.zyx.domain.Book;
import com.zyx.domain.PageBean;

public interface BlackDao {
	public Black findById(Integer id) ;
	public void delete(Black black);
	public void save(Black black);
	public boolean findstu_id(String stu_id);
	public boolean findblack(Integer id, String stu_id);
	public void update(Black black); 

	PageBean<Black> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria);
}
