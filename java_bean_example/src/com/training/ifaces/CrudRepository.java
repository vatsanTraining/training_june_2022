package com.training.ifaces;
import java.util.*;
public interface CrudRepository<T>{

	public T add(T t);
	public List<T> findAll();
	public List<T> findByName(String bookName);
}
