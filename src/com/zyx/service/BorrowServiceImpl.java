package com.zyx.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyx.dao.BooklistDao;
import com.zyx.dao.BorrowDao;
import com.zyx.domain.Book;
import com.zyx.domain.Borrow;
import com.zyx.domain.PageBean;
@Service("borrowService")
@Transactional
public class BorrowServiceImpl implements BorrowService {
	
	@Autowired
	@Qualifier("borrowDao")
	private BorrowDao borrowDao;
	@Override
	public List<Book> findallisbn() {
		
		return borrowDao.findallisbn();
	}
	@Override
	public PageBean<Borrow> findByPage(Integer mCurrentPage, Integer pageSize, DetachedCriteria criteria) {
		// TODO Auto-generated method stub
		return borrowDao.findByPage(mCurrentPage,pageSize,criteria);
	}
	
	@Override
	public int add(Borrow borrow) {
		Integer i=borrowDao.findcount(borrow.getIsbn());
		int a=borrowDao.findbar(borrow.getBar());
		if(i<=0){
			return 0;
		}
		else if(a==1){
			return 1;
		}else{
			borrowDao.countjian(borrow.getIsbn());
			borrowDao.save(borrow);
			return 2;
		}
	}

}
