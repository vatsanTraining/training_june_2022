package com.training.repos;

import java.util.List;

import com.training.ifaces.CrudRepository;
import com.training.model.Book;

public class BookRepositoryWithPostgress implements CrudRepository<Book> {

	@Override
	public Book add(Book t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findByName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

}
