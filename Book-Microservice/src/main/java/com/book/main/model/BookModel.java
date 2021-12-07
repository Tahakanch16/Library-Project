package com.book.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class BookModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String name;
	private String author;
	private int availableCopies;
	private int totalCopies;
	
	
	
	public BookModel() {
		super();
	}

	public BookModel(int bookId, String name, String author, int availableCopies, int totalCopies) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.availableCopies = availableCopies;
		this.totalCopies = totalCopies;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getAvailableCopies() {
		return availableCopies;
	}
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	public int getTotalCopies() {
		return totalCopies;
	}
	public void setTotalCopies(int totalCopies) {
		this.totalCopies = totalCopies;
	}

	@Override
	public String toString() {
		return "BookModel [bookId=" + bookId + ", name=" + name + ", author=" + author + ", availableCopies="
				+ availableCopies + ", totalCopies=" + totalCopies + "]";
	}
	
	

}
