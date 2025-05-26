package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Book;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class Test_ReadBook {

	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void read() {
		List<Book> books = bookRepository.findAll();
		books.forEach(book -> {
			System.out.printf("序號: %d 書名:%s%n 作者:%s%n", book.getId(),book.getName(),book.getAuthor().getName());
		});
		
		
	}
}
