package com.avinash.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avinash.restapi.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	public Book findById(long id);

}
