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
		
		<form class="pure-form" method="post" action="/JavaWebOrder/order/update">
			<fieldset>
				<legend>修改訂單</legend>
				Index:
				<input type="number" name="index" value="${ index }" readonly /> <p/>
				品名:
				<select name="item">
    				<c:forEach varStatus="row" var="dto" items="${ productDTOs }" >
        				<option value="${ dto.item }">品項:${ row.index + 1} ${ dto.item }</option>
  			  		</c:forEach>
				</select>
			 	<p />
			 	<button type="submit" class="button-success pure-button">修改訂單</button>
			</fieldset>
		</form>
	</body>
</html>
