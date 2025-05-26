package com.example.demo;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.model.entity.Publisher;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;

@SpringBootTest
public class Test_findAuthorBook {
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void findAuthorBooks() {
		List<Object[]> resultList = authorRepository.findAuthorsWithBooks();
		/**
		for (Object[] row : resultList) {
		    Integer id = ((Number) row[0]).intValue();    // a.id
		    String name = (String) row[1];                // a.name
		    Long bookCount = ((Number) row[2]).longValue(); // COUNT(b.name)

		    System.out.printf("序號: %d  作者:%s 著作數量: %d%n", id, name, bookCount);
		}
		*/
		resultList.forEach(row ->{
			 Integer id = ((Number) row[0]).intValue();
			 String name = (String) row[1];
			 Long bookCount = ((Number) row[2]).longValue();
			 
             System.out.printf("序號: %d  作者:%s 著作數量: %d%n", id, name, bookCount);
		});
		
	}
}

