package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Author;
import com.example.demo.model.entity.Publisher;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	@Query("select a from Author a left join fetch a.books")
	List<Author> findAllWithBooks();
	
    @Query(
            value = "SELECT a.id, a.`name`, COUNT(b.name) as book_count FROM author a LEFT JOIN  book b ON b.author_id = a.id GROUP BY  a.id",
            nativeQuery = true
        )
        List<Object[]> findAuthorsWithBooks();
}


