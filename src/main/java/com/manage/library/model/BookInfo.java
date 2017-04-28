package com.manage.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * 
* 项目名称：library			<br>  
* 类名称：BookInfo				<br>   
* 类描述：图书信息表实体类   			<br>
* 创建人：Hey Shaw 				<br>
* 创建时间：2017年1月16日 下午4:12:32 		<br>   
* 修改备注：   						<br>
* @version    					<br>    
 */
@Entity		// 表名实体类对应数据库表
@Table(name="book_info")	// 解决数据库表名与实体类名不同的问题
@JsonIgnoreProperties(value={"bookType"}) // SpringMVC中解决一对多表关系时JSON输出出现死循环的问题 
public class BookInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue	// 设置为自增
	private	Integer bookId ; // 图书 ID,主键
	private String bookCode ; // 图书编号
	private String bookName ; // 图书名称
	private String bookAuthor ; //  图书作者 
	private String publishPress ; // 出版社
	
	@Temporal(TemporalType.DATE)//限制时间格式：只记录日期不记录时间。默认是时间日期都记录
	private Date publishDate ; // 出版日期
	
	private Integer borrowed ; // 是否 借阅 （1、已借阅 , 0、未借阅）
	private String createdBy ; // 创建人
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat( pattern = "yyyy-MM-dd" )	// 解决SpingMVC 表单映射只能自动映射String和int数据类型的问题
	private Date creationTime ; // 创建时间
	@Temporal(TemporalType.DATE)
	private Date lastUpdatetime ; // 最新更新时间
	
	// optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name = "typeId")	//	这里设置JoinColum设置了外键的名字，并且BookInfo是关系维护端
    private BookType bookType;
	
	public BookInfo() {}
	
	public BookInfo(String bookCode, String bookName, String bookAuthor, String publishPress,
			Date publishDate, Integer borrowed, String createdBy, Date creationTime, Date lastUpdatetime) {
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publishPress = publishPress;
		this.publishDate = publishDate;
		this.borrowed = borrowed;
		this.createdBy = createdBy;
		this.creationTime = creationTime;
		this.lastUpdatetime = lastUpdatetime;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public BookType getBookType() {
		return bookType;
	}
	
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPublishPress() {
		return publishPress;
	}

	public void setPublishPress(String publishPress) {
		this.publishPress = publishPress;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getBorrowed() {
		return borrowed;
	}

	public void setBorrowed(Integer borrowed) {
		this.borrowed = borrowed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastUpdatetime() {
		return lastUpdatetime;
	}

	public void setLastUpdatetime(Date lastUpdatetime) {
		this.lastUpdatetime = lastUpdatetime;
	}
	
	@Override
    public String toString() {
        return String.format("BookInfo [id=%s, bookName=%s, bookAuthor=%s,bookType=%s]", bookId, bookName, bookAuthor,bookType);
    }
	
}
