<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> <!-- 核心庫 -->
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %> <!-- 格式化庫 -->
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %> <!-- 函數庫 -->

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>訂單首頁</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/JavaWebOrder/css/buttons.css">
	</head>
	<body style="padding: 20px">
		
		<form class="pure-form" method="post" action="/JavaWebOrder/order">
			<fieldset>
				<legend>訂單</legend>
				品名:
				<select name="item">
    				<c:forEach varStatus="row" var="dto" items="${ productDTOs }" >
        				<option value="${ dto.item }">${ row.index + 1} ${ dto.item } ${ dto.price }</option>
  			  		</c:forEach>
				</select>
				
					
			 	<p />
			 	<button type="submit" class="button-success pure-button">送出訂單</button>
			</fieldset>
		</form>
		
		<form class="pure-form" method="get" action="/JavaWebOrder/order">
			 <button type="submit" class="button-secondary pure-button">查看歷史資料</button>	
		</form>
		<!-- <a href="/JavaWebOrder/order">查看歷史訂單</a>  -->

	</body>
</html>