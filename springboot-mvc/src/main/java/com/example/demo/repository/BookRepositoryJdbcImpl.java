package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
@Primary
public class BookRepositoryJdbcImpl implements BookRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate; // 自動綁定 spring 內建的 JdbcTemplate 物件
	
	@Override
	public List<Book> findAllBooks() {
		//String sql = "select * from book"; // 用 * 犯規
		String sql = "select id,name,price,amount,pub from book";
		// BeanPropertyRowMapper(Book.class) 自動將每一筆紀錄注入到 Book 物件中
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
	}

	@Override
	public Optional<Book> getBookById(Integer id) {
		String sql = "select id,name,price,amount,pub from book where id = ?";
		try {
			Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class),id);
			return Optional.of(book);
		} catch (EmptyResultDataAccessException e) {
			// 沒查到資料會拋出例外
			return Optional.empty();
		}
		
		
		/*
		List<Book> books =  jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class),id);
		return books.isEmpty() ? Optional.empty() : Optional.of(books.get(0));
	    */
	}

	@Override
	public boolean addBook(Book book) {
		// 檢查 book 的 pub 是否為 null 是 null 改為 false
//		if(book.getPub() == null) {
//			book.setPub(false);
//		}
		String sql = "insert into book(name, price, amount, pub) values(?, ?, ?, ?)";
		int rows = jdbcTemplate.update(sql, book.getName(), book.getPrice(), book.getAmount(), book.getPub());
		return rows > 0;
	}

	@Override
	public boolean updateBook(Integer id, Book book) {
		// 檢查 book 的 pub 是否為 null 是 null 改為 false
//		if(book.getPub() == null) {
//			book.setPub(false);
//		}
		String sql = "update book set name = ?, price = ?, amount = ?, pub = ?  where id = ? ";
		int rows = jdbcTemplate.update(sql, book.getName(),book.getPrice(),book.getAmount(),book.getPub(),id); 
		return rows > 0;
	}

	@Override
	public boolean deleteBook(Integer id) {
		String sql = "delete from book where id = ?";
		int rows = jdbcTemplate.update(sql,id); 
		return rows > 0;
		//return jdbcTemplate.update("delete from book where id = ?",id) > 0;

	}
	
}
