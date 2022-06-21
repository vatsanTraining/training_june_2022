package com.training.services;
import java.util.*;
import java.sql.*;

import com.training.ifaces.CrudRepository;
import com.example.demo.model.*;
import com.training.repos.BookRepository;
import com.training.repos.DbBookRepository;
public class BookService {

	
	private CrudRepository<Book> repo;
	
	private Connection con;
	
	
	public BookService(Connection con) {
		super();
		
		this.con = con;
		this.repo = new DbBookRepository(con);
		
	}

		public List<Book> findAll(){
		
			//this.repo.add(new Book(101,"Java","kathy",450));
		
			return this.repo.findAll();
	}
		
	public Book add(Book entity) {
		
		return this.repo.add(entity);
	}

	public List<Book> findBookByName(String bookName) {
		return this.repo.findByName(bookName);
	}
	
	public Book remove(int id) {
		
		return this.repo.removeById(id);
	}
	
	public Book update(Book book) {
		return this.repo.update(book);
	}

	public Book findById(int id) {
		
		return this.repo.findById(id);
	}
	
}
