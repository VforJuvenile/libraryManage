package com.manage.library.dao;


import javax.persistence.Entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.manage.library.model.BookInfo;

public interface IBookInfoRepository extends JpaRepository<BookInfo, Integer> {
	
	/**
	 * 按条件分页查询
	 * @param pageable
	 * @return
	 */
	// JPA的@Query注解注释的JPQL语句中写limit语句是会报错的，FROM后面接类名，如果映射@Entity没有指定的话	
	@Query("SELECT bi FROM  BookInfo bi WHERE bookName like %?1%")
	public Page<BookInfo> getNewBookInfo(String seachName,Pageable pageable);
	
	/**
	 * 按条件返回数据条数
	 * @param bookName
	 * @return
	 */
	@Query("SELECT COUNT(*) FROM  BookInfo bi WHERE bookName like %?1%")
	public Integer getTotalPageNum(String seachName);
	
	/**
	 * 删除数据
	 * @param bookId
	 * @return
	 
	@Modifying
	@Query("DELETE FROM BookInfo WHERE bookId = ?1")
	public String delBookInfo(Integer bookId);
	*/
}
