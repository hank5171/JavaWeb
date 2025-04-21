<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>使用者資料表</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<div class="pure-form">
			<h2>咖啡資料結果</h2>
			<fieldset>
				<legend>Coffee Result</legend>
				咖啡類型: ${ coffee.coffeeType }  <p/>
				牛奶毫升數: ${ coffee.milk }  <p/>
				咖啡毫升數: ${ coffee.coffee }  <p/>
				描述:  ${ coffee.coffeeResult } <p/>
				<a href="/JavaWeb/coffee" class="pure-button pure-button-primary">返回</a>
			</fieldset>
		</div>
	</body>
</html>