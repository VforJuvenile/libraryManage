package com.manage.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manage.library.model.BookType;

public interface IBookTypeRepository extends JpaRepository<BookType, Integer>{
	
}
