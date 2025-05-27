package com.example.demo.service;

import com.example.demo.excepiton.InsufficientAmoutException;

// 買書服務
public interface BuyService {
	void buyOneBook(String username, Integer price) throws InsufficientAmoutException;
}
