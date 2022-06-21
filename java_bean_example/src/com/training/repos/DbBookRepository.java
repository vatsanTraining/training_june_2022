package com.training.repos;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.example.demo.model.Book;
import com.training.ifaces.CrudRepository;

public class DbBookRepository implements CrudRepository<Book> {
	
	private Connection con;
	
	

	public DbBookRepository(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Book add(Book t) {
		int rowAdded=0;
		String sql = "insert into vats_book values(?,?,?,?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
	) {
			
			
			pstmt.setInt(1, t.getBookNumber());
			pstmt.setString(2, t.getBookName());
			pstmt.setString(3, t.getAuthorName());
			pstmt.setDouble(4, t.getPrice());
			
			 rowAdded = pstmt.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return rowAdded==1?t:null;
	}

	@Override
	public List<Book> findAll() {

		String sql = "select * from vats_book";
	
		List<Book> bookList = new ArrayList<>();
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);
){
			
			 ResultSet rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 
				 int bookNumber = rs.getInt("bookNumber");
				String bookName=rs.getString("bookName");
				String authorName=rs.getString("authorName");
				double price=rs.getDouble("price");
				 
				Book eachBook = new Book(bookNumber, bookName, authorName, price);
				
				bookList.add(eachBook);
			 }
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		
		return bookList;
	}
	
	public Book update(Book t) {
		
		int rowsUpdated=0;
		String sql = "update vats_book set bookName=?, authorName=?,price=?  where bookNumber =?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
	) {
			
			pstmt.setString(1, t.getBookName());
			pstmt.setString(2, t.getAuthorName());
			pstmt.setDouble(3, t.getPrice());
			
			pstmt.setInt(4, t.getBookNumber());

			rowsUpdated = pstmt.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return rowsUpdated==1?t:null;

		
	}

	@Override
	public List<Book> findByName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book removeById(int id) {

		int rowDeleted=0;
		
		String sql = "delete from vats_book where bookNumber=?";
				
		try(			PreparedStatement pstmt = con.prepareStatement(sql);
) {
			
			
			pstmt.setInt(1, id);
			
			
			 rowDeleted = pstmt.executeUpdate();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return rowDeleted==1?findById(id):null;

	
	}

	public Book findById(int id) {
		
			String sql = "select * from vats_book where bookNumber=?";
		
		Book foundBook  = null;		
		try(PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			
			 ResultSet rs = pstmt.executeQuery();
			 
			 if(rs.next()) {
				 
				int bookNumber = rs.getInt("bookNumber");
				String bookName=rs.getString("bookName");
				String authorName=rs.getString("authorName");
				double price=rs.getDouble("price");
				 
				foundBook = new Book(bookNumber, bookName, authorName, price);
				
			 }
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		
		return foundBook;
	}

}
