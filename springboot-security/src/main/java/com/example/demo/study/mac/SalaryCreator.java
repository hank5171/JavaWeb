package com.example.demo.study.mac;

import java.io.File;
import java.io.IOException;

import javax.crypto.SecretKey;

import com.example.demo.study.security.KeyUtil;

/*
 * 情境描述：
 * 在一家大型企業，HR部門每月都會發送電子薪資明細給員工。
 * 為了確保薪資明細的安全性，HR部門決定對薪資明細檔案進行雜湊和 MAC 保護。
 * 雜湊保護確保薪資明細的完整性，而MAC則確保薪資明細確實來自HR部門，並未被其他部門或外部攻擊者更改。
 * 薪資檔案位置   : my_salary.txt
 * macKey檔案位置: macKey.key
 * */
public class SalaryCreator {

	public static void main(String[] args) throws Throwable {
		String salaryFilePath = "src/main/java/com/example/demo/study/mac/my_salary.txt";
		String macKeyFilePaht = "src/main/java/com/example/demo/study/mac/mackey.key";
		
		// 生成mackey
		SecretKey macKey = null;
		if(new File(macKeyFilePaht).exists()) {
			macKey = KeyUtil.getSecretKeyFromFile("HmacSHA256", macKeyFilePaht);
		} else { // mackey 不存在要自行生成
			macKey = KeyUtil.generateKeyForHmac();
			// 將 mackey 儲存到檔案
			KeyUtil.saveKeyToFile(macKey, macKeyFilePaht);
		}
		
		// 得到 my_salary.txt 的 macValue(Hex)
		String salaryMacHexValue = KeyUtil.generateMac("HmacSHA256", macKey, salaryFilePath);
		System.out.println("得到 HR 發布的 salaryMacHexValue: " +salaryMacHexValue);
	}
}
