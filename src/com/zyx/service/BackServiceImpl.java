package com.zyx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyx.dao.BackDao;
import com.zyx.dao.BorrowDao;
import com.zyx.domain.Back;
import com.zyx.domain.Book;
import com.zyx.domain.PageBean;
@Service("backService")
@Transactional
public class BackServiceImpl implements BackService {

	@Autowired
	@Qualifier("backDao")
	private BackDao backDao;
	@Override
	public PageBean<Back> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return backDao.findByPage(mCurrentPage,pageSize,criteria);
	}
	@Override
	public List<Book> findallisbn() {
		// TODO Auto-generated method stub
		return backDao.findallisbn();
	}
	@Override
	public boolean add(Back back) {
		// TODO Auto-generated method stub
			if(backDao.findbar(back.getBar())){
				
			backDao.jiacount(back.getIsbn());
			backDao.deleteborrow(back.getBar());
			backDao.addback(back);
			return true;
			}else{
				return false;
			}
			
	}

}
