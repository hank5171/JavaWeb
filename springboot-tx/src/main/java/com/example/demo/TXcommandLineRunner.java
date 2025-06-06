package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.excepiton.InsufficientAmoutException;
import com.example.demo.service.BuyService;

@Component
public class TXcommandLineRunner implements CommandLineRunner {
	
	@Autowired
	private BuyService buyService;
	
	// 買書
	private void buyBook(String username, Integer bookId) {
		try {
			buyService.buyOneBook(username, bookId);
		} catch (InsufficientAmoutException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Override
	public void run(String... args) throws Exception {
		try {
			buyBook("john", 1);
		} catch (Exception e) {
			
			System.err.println(e.getMessage());		
		}	
	}
}
