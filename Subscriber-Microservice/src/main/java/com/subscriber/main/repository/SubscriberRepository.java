package com.subscriber.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subscriber.main.model.SubscriberModel;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberModel, Integer>{

}
