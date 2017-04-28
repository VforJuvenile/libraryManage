package com.manage.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manage.library.dao.IBookInfoRepository;
import com.manage.library.model.BookInfo;
import com.manage.library.service.IBookInfoService;

@Service("IBookInfoService")
public class BookInfoServiceImpl implements IBookInfoService{

	@Autowired
	IBookInfoRepository iBookInfoDao ;
	
	@Override
	public List<BookInfo> getNewBookInfo() {
		Pageable pageable = new PageRequest(0, 8, Direction.DESC, "creationTime");
		Page<BookInfo> bookInfoPage = iBookInfoDao.getNewBookInfo("",pageable);
		List<BookInfo> bookInfoNewList = bookInfoPage.getContent();
		return bookInfoNewList;
	}

	@Override
	public List<BookInfo> getPageBookInfo(String seachName,Integer page) {
		Pageable pageable = new PageRequest(page, 10, Direction.DESC, "creationTime");
		Page<BookInfo> bookInfoPage = iBookInfoDao.getNewBookInfo(seachName,pageable);
		List<BookInfo> bookInfoPageList = bookInfoPage.getContent();
		return bookInfoPageList;
	}

	@Override
	public Integer getTotalPageNum(String seachName) {
		Integer totalPageNum = iBookInfoDao.getTotalPageNum(seachName); 
		return totalPageNum;
	}

	@Override
	public BookInfo getBookInfo(Integer id) {
		BookInfo bookInfo = iBookInfoDao.findOne(id);
		return bookInfo;
	}
	
	@Transactional
	@Override
	public String saveBookInfo(BookInfo bookInfo) {
		iBookInfoDao.save(bookInfo);
		return "完成添加！";
	}

	@Override
	public String delBookInfo(Integer bookId) {
		iBookInfoDao.delete(bookId);
		return "成功删除！";
	}
	
}
