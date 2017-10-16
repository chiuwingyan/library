package com.zyx.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyx.dao.BlackDao;
import com.zyx.dao.BooklistDao;
import com.zyx.domain.Black;
import com.zyx.domain.PageBean;
@Service("blackService")
@Transactional
public class BlackServiceImpl implements BlackService {

	@Autowired
	@Qualifier("blackDao")
	private BlackDao blackDao;
	public PageBean<Black> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return blackDao.findByPage(mCurrentPage,pageSize,criteria);
	}
	@Override
	public Black findById(Integer id) {
		return blackDao.findById(id);
	}
	@Override
	public void delete(Black black) {
		blackDao.delete(black);
		
	}
	@Override
	public boolean save(Black black) {
		boolean i=blackDao.findstu_id(black.getStu_id());
		if(i){
		blackDao.save(black);
		return true;
		}
		else
			return false;
	}
	@Override
	public boolean findblack(Integer id, String stu_id) {
		// TODO Auto-generated method stub
		return blackDao.findblack(id, stu_id);
	}
	@Override
	public void update(Black black) {
		// TODO Auto-generated method stub
		blackDao.update(black);
	}

}
