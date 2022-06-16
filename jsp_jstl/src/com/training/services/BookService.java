package com.training.services;
import java.util.*;

import com.training.ifaces.CrudRepository;
import com.training.model.Book;
import com.training.repos.BookRepository;
public class BookService {

	
	private CrudRepository<Book> repo;
	
	public BookService() {
		super();
		
		this.repo = new BookRepository();
		
	}

		public List<Book> findAll(){
		
		return this.repo.findAll();
	}
		
	public Book add(Book entity) {
		
		return this.repo.add(entity);
	}

	public List<Book> findBookByName(String bookName) {
		return this.repo.findByName(bookName);
	}
	
	
	
}
