/**
 * 
 */
package com.bookstore.app.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookstore.app.entities.Book;

/**
 * @author
 *
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findAllBycategoryId( int categoryId);
}
