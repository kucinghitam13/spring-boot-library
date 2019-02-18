package com.example.sbl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sbl.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findByAuthorName(String authorName);
}
