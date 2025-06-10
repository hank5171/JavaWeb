package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.aop.FloorService;

@SpringBootTest
public class AOPFloorTest {

	@Autowired
	private FloorService floorService;
	
	@Test
	public void Test() {
		String userName = "alice";
		int floor = 4 ;
		
		String result = floorService.enterFloor(userName,floor);
		System.out.println(result);
	}
}
