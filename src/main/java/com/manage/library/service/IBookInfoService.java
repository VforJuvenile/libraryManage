package com.manage.library.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.manage.library.model.BookInfo;
import com.manage.library.model.BookType;

/**
 * 
* 项目名称：library			<br>  
* 类名称：IBookInfoService				<br>   
* 类描述：图书信息逻辑层接口   						<br>
* 创建人：Hey Shaw 				<br>
* 创建时间：2017年1月18日 上午10:58:09 		<br>   
* 修改备注：   						<br>
* @version 1.0   					<br>    
 */
public interface IBookInfoService {
	/**
	 * 查询最新书籍列表前八
	 */
	public List<BookInfo> getNewBookInfo(); 
	
	/**
	 * 分页查询
	 */
	public List<BookInfo> getPageBookInfo(String seachName,Integer page);
	
	/**
	 * 按条件返回数据条数
	 * @param bookName
	 * @return
	 */
	public Integer getTotalPageNum(String seachName);
	
	/**
	 * 按id返回书籍信息数据
	 * @param bookName
	 * @return
	 */
	public BookInfo getBookInfo(Integer id);

	/**
	 * 保存数据
	 * @param bookInfo
	 * @return
	 */
	public String saveBookInfo(BookInfo bookInfo);
	
	/**
	 * 根据id批量删除数据
	 * @param bookId
	 * @return
	 */
	public String delBookInfo(Integer bookId);
}
