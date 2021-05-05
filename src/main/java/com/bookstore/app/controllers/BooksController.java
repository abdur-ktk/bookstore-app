package com.bookstore.app.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.app.exceptions.BookNotFoundException;
import com.bookstore.app.entities.Book;
import com.bookstore.app.repos.BookRepository;

@RestController
@CrossOrigin(origins = "http://localhost:2222")
@RequestMapping(path = "books")
public class BooksController {

	protected Logger logger = Logger.getLogger(BooksController.class.getName());

	protected BookRepository bookRepository;

	@Autowired
	public BooksController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		logger.info("****BOOKS IN STALK****");
		logger.info("****Total " + bookRepository.count() + " books****");
	}

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public Book createBook(@RequestBody Book book) {
		logger.info("****Books-Service addNewBook(book) invoked****");
		Book bookAdded = bookRepository.save(book);
		logger.info("****Books-Service new book added " + bookAdded + "****");
		if (bookAdded == null)
			throw new BookNotFoundException(0);
		else {
			return bookAdded;
		}
	}

	@RequestMapping("/list")
	public List<Book> byAll() {
		logger.info("****Books-Service byAll() invoked****");
		List<Book> books = bookRepository.findAll();

		if (books == null || books.size() == 0)
			throw new BookNotFoundException(0);
		else {
			return books;
		}
	}

	@RequestMapping(value = "/listByCategory/{categoryId}")
	public List<Book> bookByCategory(@PathVariable("categoryId") int categoryId) {
		logger.info("****Books-Service BookByCategory  invoked****");
		List<Book> books = bookRepository.findAllBycategoryId(categoryId);
		logger.info("****Books-Service BookByCategory found :" + books + " ****");
		if (books == null || books.size() == 0)
			throw new BookNotFoundException(0);
		else {
			return books;
		}
	}

	@PutMapping(value = "/changeCategory", consumes = "application/json", produces = "application/json")
	public Book changeCategory(@RequestBody Book book) {
		logger.info("****Books-Service ChangeCategory  invoked****");
		Book bookUpdated = bookRepository.save(book);
		logger.info("****Books-Service ChangedCategory found :" + book + " ****");
		if (bookUpdated == null)
			throw new BookNotFoundException(0);
		else {
			return bookUpdated;
		}
	}
}
