package com.manage.library.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
* 项目名称：library			<br>  
* 类名称：BookType				<br>   
* 类描述：图书类型表实体类   			<br>
* 创建人：Hey Shaw 				<br>
* 创建时间：2017年1月16日 下午4:30:27 		<br>   
* 修改备注：   						<br>
* @version    					<br>    
 */
@Entity		
@Table(name="book_type")
public class BookType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue	
	private Integer id ; // 主键
	
	@Column(length=30)	//限制字符串长度
	private String typeName ; // 图书类型名称
	
	/* 
	 * 这里配置关系，并且确定关系维护端和被维护端。mappBy表示关系被维护端，只有关系端有权去更新外键。
	 * 这里还有注意OneToMany默认的加载方式是赖加载。当看到设置关系中最后一个单词是Many，那么该加载默认为懒加载
	*/ 
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bookType")
/*	@JoinColumn(name = "typeId")  
		-- hibernate3.5版本之后@JoinColumn与mappingBy是互斥的，而在更早版本的hibernate是允许这两个互相存在。*/
	private Set<BookInfo> bookInfo = new HashSet<BookInfo>();
	
	public BookType() {}
	
	public BookType(String typeName) {
		this.typeName = typeName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public Set<BookInfo> getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(Set<BookInfo> bookInfo) {
		this.bookInfo = bookInfo;
	}

	
	@Override
    public String toString() {
        return String.format("BookType [id=%s, name=%s]", id, typeName);
    }
	
	 ////////////////////////////////////
    /**
     * 为类型添加书籍
     * 
     * @param bookInfo
     
    public void addBookInfo(BookInfo bookInfo) {
        if (!this.bookInfo.contains(bookInfo)) {
            this.bookInfo.add(bookInfo);
            bookInfo.setBookType(this);
        }
    }
	*/
	
    /**
     * 删除书籍 - 此为删除书籍类型的同时删除所有该类型的书籍
     * 
     * @param bookInfo
     
    public void removeBookInfo(BookInfo bookInfo) {
        if (this.bookInfo.contains(bookInfo)) {
        	bookInfo.setBookType(null);
            this.bookInfo.remove(bookInfo);
        }
    }
	*/
}
