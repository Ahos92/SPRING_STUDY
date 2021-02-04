package com.kgitbank.service;

public interface PageService {

	final int PAGINATION_SIZE = 7;

	int startPage(int pageNum);
	
	int endPage(int pageNum);
	
	int lastPage(int amount);
	
	boolean prevPage(int pageNum);
	
	boolean nextPage(int pageNum,int amount);	
}
