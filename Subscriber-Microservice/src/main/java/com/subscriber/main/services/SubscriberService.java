package com.subscriber.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subscriber.main.model.SubscriberModel;
import com.subscriber.main.repository.SubscriberRepository;

@Service
public class SubscriberService {
	
	@Autowired
	SubscriberRepository repo;
	
	public List<SubscriberModel> getAllSubscriber(){
		return repo.findAll();
	}
	
	public SubscriberModel addSubscriber(SubscriberModel subscriber) {
		return repo.save(subscriber);
	}
	
	public SubscriberModel getSubscriberById(int id) {
		SubscriberModel model=null;
		try {
			model=repo.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
		
	}
	
	public void deleteSubscriberById(int id) {
		repo.deleteById(id);
	}
}
