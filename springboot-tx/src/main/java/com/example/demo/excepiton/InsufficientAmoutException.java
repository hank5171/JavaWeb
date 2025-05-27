package com.example.demo.excepiton;

// 餘額/庫存不足
public class InsufficientAmoutException extends Exception {
	public InsufficientAmoutException(String message) {
		super(message);
	}
}
