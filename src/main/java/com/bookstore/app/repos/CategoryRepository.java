package com.bookstore.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.app.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	
}
