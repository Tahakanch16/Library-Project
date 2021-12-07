package com.book.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.main.model.BookModel;
import com.book.main.services.BookService;

@RestController
@RequestMapping("/library")
public class BookController {
	
	@Autowired 
	BookService service;
	
	@PostMapping("/book")
	public BookModel addBook(@RequestBody BookModel book) {
		return service.addBook(book);
	}
	
	@GetMapping("/book")
	public List<BookModel> getAllBooks(){
		return service.getAllBookDetails();
	}
	
	@GetMapping("/book/{id}")
	public BookModel getBookById(@PathVariable("id") int id) {
		return service.getBookById(id);
	}
	
	@PutMapping("/book/{bookId}")
	public BookModel updateBookById(@PathVariable("bookId") int id, @RequestBody BookModel book) {
		System.out.println(book);
		return service.updateBookDetails(id, book);
	}

}
