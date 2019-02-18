package com.example.sbl.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbl.model.Book;
import com.example.sbl.repository.BookRepository;

@RestController
@RequestMapping("book")
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Book>>getMemberById(@PathVariable(value = "id") long bookId) {
		Optional<Book> book = bookRepository.findById(bookId);
		return ResponseEntity.ok().body(book);
	}
	
	@PostMapping
	public Book addBook(@Valid @RequestBody Book book) {
		return bookRepository.save(book);
	}
}
