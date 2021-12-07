package com.subscriber.main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Subscriber")
public class SubscriberModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subscriberId;
	
	private String name;
	
	@CreationTimestamp
	private java.sql.Date DateOfSubscribed;
	private java.sql.Date DateOfReturned;
	private int bookId;
	
	public SubscriberModel() {
		super();
	}

	public SubscriberModel(int subscriberId, String name, java.sql.Date dateOfSubscribed, java.sql.Date dateOfReturned,
			int bookId) {
		super();
		this.subscriberId = subscriberId;
		this.name = name;
		DateOfSubscribed = dateOfSubscribed;
		DateOfReturned = dateOfReturned;
		this.bookId = bookId;
	}

	public int getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(int subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.sql.Date getDateOfSubscribed() {
		return DateOfSubscribed;
	}

	public void setDateOfSubscribed(java.sql.Date dateOfSubscribed) {
		DateOfSubscribed = dateOfSubscribed;
	}

	public java.sql.Date getDateOfReturned() {
		return DateOfReturned;
	}

	public void setDateOfReturned(java.sql.Date dateOfReturned) {
		DateOfReturned = dateOfReturned;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "SubscriberModel [subscriberId=" + subscriberId + ", name=" + name + ", DateOfSubscribed="
				+ DateOfSubscribed + ", DateOfReturned=" + DateOfReturned + ", bookId=" + bookId + "]";
	}
	
	
	
}
