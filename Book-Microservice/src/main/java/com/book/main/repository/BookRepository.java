package com.book.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.main.model.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {

}
