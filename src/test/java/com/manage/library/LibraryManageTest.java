package com.manage.library;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.manage.library.dao.IBookInfoRepository;
import com.manage.library.dao.IBookTypeRepository;
import com.manage.library.model.BookInfo;
import com.manage.library.model.BookType;
import com.manage.library.service.IBookInfoService;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest		// 开始加的@DataJpaTest不行，读不到配置文件
public class LibraryManageTest {
	
	@Autowired
	private IBookInfoRepository iBInfoDao ;
	@Autowired
	private IBookTypeRepository iBTypeDao ;
	@Autowired
	private IBookInfoService iBookInfoService ;
	
	
    /**
     * 添加书籍类型bookType的同时添加bookInfo，因为书籍类型bookType为双向关系维护者，起着主导作用
     */
	@Test
    public void save() {
    	BookType bType = new BookType();
    	BookType bType2 = new BookType();
    	bType.setTypeName("小说");
    	bType2.setTypeName("科技");
//    	bType.addBookInfo(new BookInfo("BK000001","天龙八部","金庸","中原出版社",new Date(),0,"张三",new Date(),new Date()));
//    	bType2.addBookInfo(new BookInfo("BK000002","企业应用架构模式","(英)Martin Fowler","机械工业出版社",new Date(),1,"张三",new Date(),new Date()));
//    	bType2.addBookInfo(new BookInfo("BK000003","精通Hibernate","刘洋","电子工业出版社",new Date(),0,"张三",new Date(),new Date()));
    	iBTypeDao.save(bType);
    	iBTypeDao.save(bType2);
    }
    
    /**
     * 删除
     */
    @Test
    public void detele(){
//    	iBInfoDao.delete(8);
    }
    
  /*  @Test
    public void update(){
    	BookType booktype = iBTypeDao.findOne(5);
    	booktype.setTypeName("武侠小说");
    	iBTypeDao.save(booktype);
    	BookInfo bookInfo = iBInfoDao.findOne(7);
    	System.out.println(bookInfo);
    }
    */
    
    
    //条件查询
    @Test
    public void listInfo(){
    	List<BookInfo> bookInfoNewList =  iBookInfoService.getNewBookInfo();
    	for (BookInfo bookInfo : bookInfoNewList) {
    		System.out.println(bookInfo);
		}
    }
}
