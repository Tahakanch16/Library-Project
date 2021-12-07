package com.book.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.main.model.BookModel;
import com.book.main.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repo;
	
	public List<BookModel> getAllBookDetails(){
		return repo.findAll();
	}
	
	public BookModel addBook(BookModel book) {
		return repo.save(book);
	}
	
	public BookModel getBookById(int id) {
		return repo.findById(id).get();
	}
	
	public BookModel updateBookDetails(int id,BookModel book) {
		
		BookModel bookDetails=repo.findById(id).get();
		bookDetails.setAvailableCopies(book.getAvailableCopies());
		System.out.println(bookDetails);
		return repo.save(bookDetails);
	}

}
