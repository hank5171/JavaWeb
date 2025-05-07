package com.example.demo.controller;

import org.modelmapper.internal.bytebuddy.implementation.bytecode.constant.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BMI;
import com.example.demo.response.ApiResponse;

import java.lang.Math;

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

	/*
	 * 2. ?後代參數
	 * 路徑: /great?name=John&age=18
	 * 路徑: /great?name=Mary
	 * 路徑: http://localhost:8080/api/greet?name=john&age=18
	 * 結果: Hi John, 18(成年)
	 * 路徑: http://localhost:8080/api/greet?name=Mary
	 * 結果: Hi Mary, 0(未成年) 
	 * 限制: name 參數一定要加, age 為可選參數(會有初始值 0)
	 * */
	
	@GetMapping("/greet")
	public String greet(@RequestParam(value = "name", required = true) String username,
			@RequestParam(value ="age" ,required =  false, defaultValue = "0") Integer userage) {
		
		String result = String.format("Hi %s %d (%s)",
				username, userage, userage >=18 ? "成年":"未成年");
		return result ;
	}
	
	// 3. 上述 2. 的精簡寫法
	@GetMapping("/greet2")
	public String greet2(@RequestParam String name,
			@RequestParam(defaultValue = "0")  Integer age) {
		
		String result = String.format("Hi %s %d (%s)",
				name, age, age >=18 ? "成年":"未成年");
		return result ;
	}
	
	/*
	 * 4. Lab 練習
	 * 路徑: /bmi?h=170&w=60
	 * 網址: http://localhost:8080/api/bmi?h=170&w=60
	 * 執行結果: 
	 * 	{
	 * 	   "status": 200,
	 * 	   "message": "BMI 計算成功",
	 * 	   "data":{
	 * 		  "height": 170.0,
	 * 		  "weight": 60.0,
	 * 		  "bmi": 20.76
	 * 		}
	 * 	}
	 * */
	
	@GetMapping(value = "/bmi", produces = "application/json;charset=utf-8")
	public ApiResponse calcBmi(@RequestParam(required = false) Double h,
						  @RequestParam(required = false) Double w) {
		if(h == null || w == null) {
			/*
			return """	 
		    		{
		    		  "status": 400	,
		    		  "message": "請提供身高(h)或體重(w)",
		    		  "data": null
		    		}
		    		""";
			*/
			return ApiResponse.error(400, "請堤供身高(h)或體重(w)");	
		}
		
	    double heightInMeters = h / 100.0;  // 注意：使用 100.0 才會變浮點數
	    double bmi = w / Math.pow(heightInMeters, 2);
	    String result = String.format("bmi = %.2f", bmi);  // 小數點兩位
	    
	    return ApiResponse.success("BMI 計算成功", new BMI(h,w,bmi));
	}
}