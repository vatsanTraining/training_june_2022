package com.training.repos;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.model.Book;
import com.training.ifaces.CrudRepository;

public class BookRepository implements CrudRepository<Book> {

	private List<Book> bookList;
	
	
	public BookRepository() {
		super();

		// get the connection 
		
		//Connection con = DriverManager.getConnection(url)
				                      
		this.bookList = new ArrayList<Book>();
	}

	@Override
	public Book add(Book t) {
		boolean  isAdded =this.bookList.add(t);
		
		if(isAdded) {
			return t;
		} else {
			return null;
		}
		
		
	}

	@Override
	public List<Book> findAll() {
		return this.bookList;
	}

	@Override
	public List<Book> findByName(String bookName) {
			List<Book>  found =
					this.bookList.stream()
					  .filter(e -> e.getBookName().equals(bookName)).collect(Collectors.toList());
		
			return found;
	}

	@Override
	public Book removeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book update(Book t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
