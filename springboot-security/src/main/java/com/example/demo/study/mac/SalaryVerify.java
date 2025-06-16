package com.example.demo.study.mac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.crypto.SecretKey;

import com.example.demo.study.security.KeyUtil;

/*
 * 員工已知或得到的資訊
 * 薪資檔案位置 : my_salary.txt
 * macKey 檔案位置: macKey.key
 * 得到 HR 發布的 salaryMacHexValue : 7d458ff47bef6ae332d151c300037471d9b7b1652ae6d0abdd9c84bd6ae45171
 * 
 * 如何得知 my_salary.txt 是由 HR 所發布的　? (來源確認)
 * 
 */

public class SalaryVerify {
	public static void main(String[] args) throws Throwable {
		String salaryFilePath = "src/main/java/com/example/demo/study/mac/my_salary.txt";
		String macKeyFilePath = "src/main/java/com/example/demo/study/mac/mackey.key";
		
		SecretKey macKey = KeyUtil.getSecretKeyFromFile("HmacSHA256", macKeyFilePath);
		
		// 已知(Copy 自 SalaryCreator.java 執行的結果)
		String salaryMacHexValue = "7d458ff47bef6ae332d151c300037471d9b7b1652ae6d0abdd9c84bd6ae45171";
		
		// 生成 computedSalaryMacHexValue
		String computedSalaryMacHexValue = KeyUtil.generateMac("HmacSHA256", macKey, salaryFilePath);
		
		// 驗證
		if(salaryMacHexValue.equals(computedSalaryMacHexValue)) {
			System.out.println("MAC 驗證成功, 資料來自於 HR");
			// 讀取檔案內容
			System.out.println(Files.readString(Path.of(salaryFilePath)));
		} else {
			System.out.println("MAC 驗證失敗");
		}
				
	}
}
