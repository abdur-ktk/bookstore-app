package com.bookstore.app.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



/**
 * @author
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(int id) {
		super("No such book: " + id);
	}
}
