package com.kgitbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgitbank.mapper.EmployeeMapper;

@Service
public class PageServiceImpl implements PageService {

	@Autowired
	EmployeeMapper emp_mapper; 
	
	@Override
	public int startPage(int pageNum) {
		return pageNum % PAGINATION_SIZE == 0 ? 
				endPage(pageNum) - (PAGINATION_SIZE - 1) : endPage(pageNum) - (PAGINATION_SIZE - 1);
	}

	@Override
	public int endPage(int pageNum) {
		return  pageNum % PAGINATION_SIZE == 0 ? 
				(pageNum / PAGINATION_SIZE) * PAGINATION_SIZE :  
				(pageNum / PAGINATION_SIZE + 1) * PAGINATION_SIZE;
	}

	@Override
	public int lastPage(int amount) {
		int total = emp_mapper.getEmployeeCount();
		return total % amount == 0 ? total /amount : total /amount + 1;
	}

	@Override
	public boolean prevPage(int pageNum) {
		return startPage(pageNum) != 1;
	}

	@Override
	public boolean nextPage(int pageNum, int amount) {
		return endPage(pageNum) != lastPage(amount);
	}

}
