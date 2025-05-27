package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.excepiton.InsufficientAmoutException;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.StockRepository;
import com.example.demo.repository.WalletRepository;
import com.example.demo.service.BookService;

@Service // 書籍服務
public class BookServiceImpl implements BookService{

	@Autowired 
	private BookRepository bookRepository;
	
	@Autowired 
	private StockRepository stockRepository;
	
	@Autowired 
	private WalletRepository walletRepository;
	
	@Override
	public Integer getBookPrice(Integer bookId) {
		return bookRepository.getBookPrice(bookId);
	}

	@Override
	public Integer getBookAmount(Integer bookId) {
		return stockRepository.getBookAmount(bookId);
	}

	@Override
	public Integer getWalletBalance(String username) {
		return walletRepository.getWalletBalance(username);
	}

	@Override
	public void reduceBookAmount(Integer bookId, Integer amountToReduce)  throws InsufficientAmoutException {
		// 1. 檢查庫存
		Integer bookAmount = getBookAmount(bookId);
		if (bookAmount < amountToReduce) {
			throw new RuntimeException(String.format("bookId: %d 庫存餘額不足 (%ㄎd < %d)%n", bookId, bookAmount,amountToReduce));
		}
		// 2. 更新庫存
		stockRepository.updateBookAmount(amountToReduce, bookId);
	}

	@Override
	public void reduceWalletBalance(String username, Integer bookPrice) throws InsufficientAmoutException {
		// 1.檢查餘額
		Integer walletBalance = getWalletBalance(username);
		if(walletBalance < bookPrice) {
			throw new RuntimeException(String.format("使用者:%s 餘額(%d < %d) 餘額不足", username, walletBalance , bookPrice));
		}
		walletRepository.updateWalletBalance(bookPrice, username);
	}

}
