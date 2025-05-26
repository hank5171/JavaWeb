package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Author;
import com.example.demo.model.entity.Biography;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BiographyRepository;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class Test_AddBiography {

	@Autowired
	private BiographyRepository biographyRepository;
	
	@Autowired 
	private AuthorRepository authorRepository;
	
	@Test
	public void add() {
		Optional<Author> optAuthor = authorRepository.findById(2);
		if(optAuthor.isEmpty()) {
			System.out.println("查無作者");
			return;
		}
		
		Author author = optAuthor.get();
		
		Biography biography = new Biography();
		biography.setDetails("我是一個技術本位的 IT 作者...");
		biography.setAuthor(author);
		
		biographyRepository.save(biography);
	}
}
