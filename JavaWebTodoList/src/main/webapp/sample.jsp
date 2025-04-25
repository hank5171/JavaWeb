<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<form method="post">  <!-- 資料敏感跟資料量多用 post 網址上看不到代的資料   反之 get 會顯示在網址上  -->
			<input type="test" name="userName"> </p>
			<input type="password" name="password"> </p>
			<button type="submit">send</button>
			<a href="sample.jsp?aaa=1">Link</a>
		</form>
	</body>
</html>