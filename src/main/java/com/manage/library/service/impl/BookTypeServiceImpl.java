package com.manage.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.library.dao.IBookTypeRepository;
import com.manage.library.model.BookType;
import com.manage.library.service.IBookTypeService;

@Service("IBookTypeService")
public class BookTypeServiceImpl implements IBookTypeService{
	
	@Autowired
	IBookTypeRepository iBookTypeDao ;
	
	public List<BookType> getBookTypeList(){
		List<BookType> bookTypeList = iBookTypeDao.findAll();
		return bookTypeList;
	}

	@Override
	public String saveBookType(BookType bookType) {
		
		List<BookType> booktyPeList = iBookTypeDao.findAll();
		for (BookType bookTpList : booktyPeList) {
			if(bookTpList.getTypeName().equals(bookType.getTypeName())){
				return "类型已存在";
			}
		}
		iBookTypeDao.save(bookType);
		return "添加成功";
	}
}
