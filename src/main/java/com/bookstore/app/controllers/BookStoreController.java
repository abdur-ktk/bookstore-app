package com.bookstore.app.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.entities.Book;
import com.bookstore.app.entities.BookStore;
import com.bookstore.app.exceptions.BookNotFoundException;
import com.bookstore.app.repos.BookStoreRepository;

@RestController
@CrossOrigin(origins = "http://localhost:2222")
@RequestMapping(path = "bookstore")
public class BookStoreController {

	protected Logger logger = Logger.getLogger(BookStoreController.class.getName());
	protected BookStoreRepository bookStoreRepository;

	@Autowired
	public BookStoreController(BookStoreRepository bookStoreRepository) {
		this.bookStoreRepository = bookStoreRepository;
		logger.info("****Available Stores****");
		logger.info("****Total " + bookStoreRepository.count() + " stores****");
	}

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public BookStore createStore(@RequestBody BookStore bookStore) {
		logger.info("****BookStore-Service createStore(book) invoked****");
		BookStore bookStoreAdded = bookStoreRepository.save(bookStore);
		logger.info("****BookStore-Service new book added " + bookStoreAdded + "****");
		if (bookStoreAdded == null)
			throw new BookNotFoundException(0);
		else {
			return bookStoreAdded;
		}
	}

	@PostMapping(value = "/addbook", consumes = "application/json", produces = "application/json")
	public BookStore addBookToStore(@RequestBody BookStore book) {
		logger.info("****BookStore-Service addBookToStore(book) invoked****");
		BookStore bookAdded = bookStoreRepository.save(book);
		logger.info("****BookStore-Service new book added " + bookAdded + "****");
		if (bookAdded == null)
			throw new BookNotFoundException(0);
		else {
			return bookAdded;
		}
	}

	@DeleteMapping("/delete")
	public String deleteBookFromBookStore(@RequestBody BookStore book) {
		logger.info("****BookStore-Service deleteBookFromBookStore invoked****");
		boolean success = false;
		bookStoreRepository.delete(book);
		success = true;
		logger.info("****BookStore-Service book deleted ****");
		if (success == false)
			throw new BookNotFoundException(0);
		else {
			return "Delete success!";
		}
	}
}
