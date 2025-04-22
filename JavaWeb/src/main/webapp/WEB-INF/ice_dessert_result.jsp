<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> <!-- 核心庫 -->
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %> <!-- 格式化庫 -->
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %> <!-- 函數庫 -->
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>🍧冰果店的點餐結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<div class="pure-form">
			<h2>🍧冰果店的點餐結果</h2>
			<fieldset>
				<legend>Order Result</legend>
				<table class="pure-table pure-table-bordered">
						<tr>
							<th>主餐: </th>
							<th>附餐:</th>
							<th>價格:</th>
						</tr>
						<tr>
							<td>${ iceDessert.mainDish }</td>
							<td>${ iceDessert.toppingsAsString }</td>
							<td> ${ iceDessert.price}</td>
						</tr>
				</table>
				
				${iceDessert}
				<a href="/JavaWeb/ice" class="pure-button pure-button-primary">返回</a>
			</fieldset>
		</div>
	</body>
</html>