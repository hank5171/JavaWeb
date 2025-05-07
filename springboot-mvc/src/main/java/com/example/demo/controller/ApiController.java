package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController  // 免去撰寫 @ResponeseBody, 但若要透過 jsp 渲染則不試用
@RequestMapping("/api") // 統一 url 前墜
public class ApiController {
	
	/*
	 * 1. 歡迎頁
	 * 路徑: /api/home
	 * 路徑: /api/
	 * 網址  http://localhost:8080/api/home
	 * 網址  http://localhost:8080/api/
	 * 
	 * */
	
	@GetMapping( value = {"/home", "/"} )
	public String home() {
		return "我是首頁";
	}


	
}
