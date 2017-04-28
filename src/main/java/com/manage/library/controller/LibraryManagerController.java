package com.manage.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.library.model.BookInfo;
import com.manage.library.model.BookType;
import com.manage.library.service.IBookInfoService;
import com.manage.library.service.IBookTypeService;


/**
* 项目名称：library		<br>								
* 类名称：LibraryManagerController		<br>	  
* 类描述：   	<br>					
* 创建人：Hey Shaw 		<br>		
* 创建时间：2017年1月16日 下午2:57:34 	<br>	 
* 修改备注：   					<br>	
* @version  1.0  			<br>		
*/
@Controller
public class LibraryManagerController {
	
	@Autowired
	IBookInfoService iBookInfoService ;
	@Autowired
	IBookTypeService iBookTypeService ;
	
	/**
	 * 管理首页 - 获取最新入库书籍放入Model传入后台
	 * @param model
	 * @return	-- 进入index页面
	 */
	@GetMapping(value="/index") // 相当于,@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(Model model){
		List<BookInfo> bookInfoNewList =  iBookInfoService.getNewBookInfo();
		model.addAttribute("bookInfoNewList", bookInfoNewList);
		return "index";
	}
	
	/**
	 * 书籍储存详情页
	 * @param seachName -- 搜索框关键词
	 * @param page	-- 当前页数
	 * @param model
	 * @return	--	进入bookList页面
	 */
	@RequestMapping(value="/bookList")
	public String bookList(
			@RequestParam(value="seachName", required = false,defaultValue="")String seachName,
				@RequestParam(value="page", required = false,defaultValue = "0")Integer page,Model model){
		List<BookInfo> bookInfoList = iBookInfoService.getPageBookInfo(seachName, page);
		int totalPageNum = iBookInfoService.getTotalPageNum(seachName) ;	// 按条件获取的总数据数
		model.addAttribute("page", page);
		model.addAttribute("seachName", seachName);
		model.addAttribute("bookInfoList", bookInfoList);
		model.addAttribute("totalPageNum", Math.ceil(totalPageNum/10));		// 按条件的总页数
		return "bookList";
	}
	
	/**
	 * 添加书籍页面，获取了书籍类型库的数据放入增加页面的下拉框中
	 * @param model
	 * @return	--	进入bookAdd页面
	 */
	@RequestMapping(value="/bookAdd")
	public String bookAdd(Model model){
		List<BookType> bookTypeList = iBookTypeService.getBookTypeList();
		model.addAttribute("bookTypeList",bookTypeList);
		return "bookAdd";
	}
	
	/**
	 * 保存新增书籍，重定向到书籍储存详情页
	 * @param bookInfoAdd
	 * @return	--	重定向到bookList页面
	 */
	@RequestMapping(value="/saveBookInfo",method=RequestMethod.POST)
	public String saveBookInfo(BookInfo bookInfoAdd){
		iBookInfoService.saveBookInfo(bookInfoAdd);
		return "redirect:/bookList" ;
	}
	
	/**
	 * 单本书籍详情页，根据前台传入的id，查看书籍详情。
	 * @param id
	 * @param model
	 * @return	--	进入bookInfo页面
	 */
	@RequestMapping(value="/bookInfo", method = RequestMethod.GET)
	public String bookInfo(@RequestParam(value="id")Integer id, Model model){
		BookInfo bookInfo = iBookInfoService.getBookInfo(id);
		model.addAttribute("bookInfo", bookInfo);
		return "bookInfo";
	}
	
	/**
	 * 单本书籍信息修改页，根据前台传入的id修改书籍信息
	 * @param id
	 * @param model
	 * @return -- 进入bookUpdate页面
	 */
	@RequestMapping(value="/bookUpdate")
	public String bookUpdate(@RequestParam(value="id")Integer id,Model model){
		BookInfo bookInfo = iBookInfoService.getBookInfo(id);
		List<BookType> bookTypeList = iBookTypeService.getBookTypeList();
		model.addAttribute("bookInfo", bookInfo);
		model.addAttribute("bookTypeList",bookTypeList);	// 获取书籍类型信息
		return "bookUpdate";
	}
	
	/**
	 * 书籍类型新增处理的Controller，根据前台填写并传入的数据类型名称，存储新增书籍类型
	 * @param typeName 
	 * @return -- 操作是否成功！
	 */
	@RequestMapping(value="/addBookType")
	@ResponseBody
	public String addBookType(@RequestParam(value="typeName")String typeName){
		if(typeName!=null && !"".equals(typeName.replaceAll(" ",""))){
			BookType bookType = new BookType(typeName);
			String info = iBookTypeService.saveBookType(bookType);
			return info;
		}
		return "类型不能为空！";
	}
	
	/**
	 * 保存单本书籍信息修改的Controller，根据前台传入的id进行保存
	 * @param bookInfoUpdate
	 * @param id
	 * @return -- 重定向到bookList
	 */
	@RequestMapping(value="/updateBookInfo/{id}",method=RequestMethod.POST)
	public String updateBookInfo(BookInfo bookInfoUpdate,@PathVariable Integer id){
		bookInfoUpdate.setBookId(id);
		iBookInfoService.saveBookInfo(bookInfoUpdate);
		return "redirect:/bookList";
	}
	
	/**
	 * 批量删除书籍信息，根据前台传入的bookIdArys参数进行批量删除
	 * @param bookIdArys -- 前台选中的书籍信息id数组
	 * @return -- 操作是否成功！
	 */
	@RequestMapping(value="/deleteBookInfo")
	@ResponseBody
	public String deleteBookInfo(@RequestParam("bookIdAry[]")Integer[] bookIdArys){
		String delInfo = null;
		for (Integer bookId : bookIdArys) {
			delInfo = iBookInfoService.delBookInfo(bookId);
		}
		return delInfo;
	}
	
}
