/**
 * 
 */
package com.bookstore.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author
 *
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "category_id")
	private int categoryId;
	public Book() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param bookId
	 * @param bookName
	 * @param categoryId
	 */
	public Book(int bookId, String bookName, int categoryId) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.categoryId = categoryId;
	}



	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}



	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}



	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", categoryId=" + categoryId + "]";
	}

	
	
}
