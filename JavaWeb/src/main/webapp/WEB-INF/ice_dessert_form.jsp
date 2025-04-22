<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> <!-- 核心庫 -->
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %> <!-- 格式化庫 -->
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %> <!-- 函數庫 -->
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>🍧冰果店的點餐系統</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<div >
		<form class="pure-form" method="POST" action"/JavaWeb/ice">
			<h2>🍧冰果店的點餐系統</h2>
				<fieldset>
					<legend>選擇主餐</legend>
					<!-- 單選用 req.getParamter("mainDish") 會得到 String -->
					<input type="radio" name="mainDish" value="剉冰" checked>🍧剉冰 (50元)<p/>
					<input type="radio" name="mainDish" value="豆花" checked>🍮豆花 (40元)<p/>
				</fieldset>
				<fieldset>
					<legend>選擇加料 (一個10元)</legend>
					<!-- 多選用 後台使用 req.getParamterValues("toppings") 會得到 String[] -->
					<input type="checkbox" name="toppings" value="花生" checked>🥜花生<p/>
					<input type="checkbox" name="toppings" value="綠豆" checked>🌱綠豆<p/>
					<input type="checkbox" name="toppings" value="紅豆" checked>🍒紅豆<p/>
					<input type="checkbox" name="toppings" value="芋圓" checked>🥔芋圓<p/>
					<input type="checkbox" name="toppings" value="粉圓" checked>⚪粉圓<p/>
					<input type="checkbox" name="toppings" value="煉乳" checked>🍼煉乳<p/>	
				</fieldset>
				<button type="submit" class="pure-button pure-button-primary">結帳</button>
			</form>
		</div>
	</body>
</html>