package com.bookstore.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookstore.app.entities.BookStore;

public interface BookStoreRepository extends JpaRepository<BookStore, Integer> {

}
