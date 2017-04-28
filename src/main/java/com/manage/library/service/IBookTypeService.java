package com.manage.library.service;

import java.util.List;

import com.manage.library.model.BookType;

/**]
 * 
* 项目名称：library			<br>  
* 类名称：IBookTypeService				<br>   
* 类描述：书籍类型逻辑层接口   						<br>
* 创建人：Hey Shaw 				<br>
* 创建时间：2017年1月18日 上午11:00:15 		<br>   
* 修改备注：   						<br>
* @version  1.0  					<br>    
 */
public interface IBookTypeService {
	
	/**
	 * 查出全部书籍类型
	 */
	public List<BookType> getBookTypeList();
	
	/**
	 * 保存新增书籍类型
	 */
	public String saveBookType(BookType bookType);
	
}
