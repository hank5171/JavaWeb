<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Drink Order</title>
	</head>
	<body>
		<div>
			<fieldset>
				<legend>Drink Order</legend>
				咖啡: ${ DrinkOrder.type }<br /> 
				容量: ${ DrinkOrder.size }<br /> 
				有無冰: ${ DrinkOrder.ice }<br /> 
				${ DrinkOrder.info }<br /> 
			</fieldset>
		</div>
	</body>
</html>