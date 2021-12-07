package com.subscriber.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.subscriber.main.model.BookModel;
import com.subscriber.main.model.SubscriberModel;
import com.subscriber.main.services.SubscriberService;

@RestController
@RequestMapping("/library")
public class SubscriberController {
	
	@Autowired
	SubscriberService service;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/subscriber")
	public ResponseEntity<List<SubscriberModel>> getAllSubscriber(){
		
		List<SubscriberModel> list=service.getAllSubscriber();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/subscriber/{id}")
	public ResponseEntity<SubscriberModel> getSubscriberById(@PathVariable("id") int id) {
		 SubscriberModel subscriber=service.getSubscriberById(id);
		 
		 if(subscriber == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(subscriber));
	}
	
	@PostMapping("/subscriber")
	public ResponseEntity<SubscriberModel> addSubscriber(@RequestBody SubscriberModel subscriber) {
		
		SubscriberModel subscriberDetails=new SubscriberModel();
		
		BookModel book=this.restTemplate.getForObject("http://book-microservice/library/book/"+subscriber.getBookId(),BookModel.class);
//		System.out.println(book);
		if(book.getAvailableCopies() != 0 && book.getAvailableCopies() <= book.getTotalCopies()) {
			
			try {
				subscriberDetails=service.addSubscriber(subscriber);
				
				int availableBooks=book.getAvailableCopies();
				availableBooks--;
				
				BookModel bookModel=new BookModel(availableBooks);
				restTemplate.put("http://book-microservice/library/book/"+subscriber.getBookId(), bookModel);
				
				return ResponseEntity.of(Optional.of(subscriberDetails));
			} 
			
			catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
		
		return ResponseEntity.status(HttpStatus.valueOf("No books Available")).build();
	}
	
	@DeleteMapping("/subscriber/{id}")
	public ResponseEntity<Void> deleteSubscriberByBookId(@PathVariable("id") int id) {
		
		SubscriberModel subscriberDetails=new SubscriberModel();
		
		try {
			
			subscriberDetails=service.getSubscriberById(id);
			
			BookModel book=this.restTemplate.getForObject("http://book-microservice/library/book/"+subscriberDetails.getBookId(),BookModel.class);
			
				int availableBooks=book.getAvailableCopies();
				availableBooks++;
				
				
				BookModel bookModel=new BookModel(availableBooks);
				restTemplate.put("http://book-microservice/library/book/"+subscriberDetails.getBookId(), bookModel);
				
				service.deleteSubscriberById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} 
		
		catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
}
