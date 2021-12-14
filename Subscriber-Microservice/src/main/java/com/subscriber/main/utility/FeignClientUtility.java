package com.subscriber.main.utility;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.subscriber.main.model.BookModel;

@FeignClient(name = "book-microservice/library/book")

public interface FeignClientUtility {
	
	@GetMapping("/{id}")
	public BookModel getBookById(@PathVariable("id") int id);
	
	@PutMapping("/{bookId}")
	public BookModel updateBookById(@PathVariable("bookId") int id, @RequestBody BookModel bookModel);
	
	@GetMapping("")
	public List<BookModel> getAllBook();
}
