package com.bookstore.app.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.app.entities.Book;
import com.bookstore.app.entities.Category;
import com.bookstore.app.exceptions.BookNotFoundException;
import com.bookstore.app.repos.CategoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:2222")
@RequestMapping(path = "category")
public class CategoryController {

	protected Logger logger = Logger.getLogger(CategoryController.class.getName());
	protected CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryController (CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
		logger.info("****Available Categories****");
		logger.info("****Total " + categoryRepository.count() + " categories****");
	}
	
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public Category createCategory(@RequestBody Category category) {
		logger.info("****Categoru-Service addNewCategory(category) invoked****");
		Category categoryAdded = categoryRepository.save(category);
		logger.info("****Books-Service new category added " + categoryAdded + "****");
		if (categoryAdded == null)
			throw new BookNotFoundException(0);
		else {
			return categoryAdded;
		}
	}
}
