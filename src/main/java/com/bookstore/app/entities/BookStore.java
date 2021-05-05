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
@Table(name="bookstore")
public class BookStore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "store_name")
	private String storeName;
	@Column(name = "book_id")
	private int bookId;
	@Column(name = "book_price")
	private float bookPrice;
	@Column(name = "city")
	private String city;
	public BookStore() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param storeId
	 * @param storeName
	 * @param bookId
	 * @param bookPrice
	 * @param city
	 */
	public BookStore(int id, String storeName, int bookId, float bookPrice, String city) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.bookId = bookId;
		this.bookPrice = bookPrice;
		this.city = city;
	}
	/**
	 * @return the storeId
	 */
	public int getStoreId() {
		return id;
	}
	/**
	 * @param storeId the storeId to set
	 */
	public void setStoreId(int storeId) {
		this.id = storeId;
	}
	/**
	 * @return the storeName
	 */
	public String getStoreName() {
		return storeName;
	}
	/**
	 * @param storeName the storeName to set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
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
	 * @return the bookPrice
	 */
	public float getBookPrice() {
		return bookPrice;
	}
	/**
	 * @param bookPrice the bookPrice to set
	 */
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "BookStore [id=" + id + ", storeName=" + storeName + ", bookId=" + bookId + ", bookPrice="
				+ bookPrice + ", city=" + city + "]";
	}
	

}
