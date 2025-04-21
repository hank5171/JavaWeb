<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<style>
			.form_container	{
				max-witdh: 500px;
				margin: 50px auto;
				padding: 20px;
			}
			h2	{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div class="form-container">
			<h2>使用者資料表單</h2>
			<form class="pure-form pure-form-staked" method="post" action"/JavaWed/user">
				<fieldset>
					<legend>User Form</legend>
					<label>姓名:</label>
					<input name="userName" type="text" required="required"/>
					
					<label>性別:</label>
					<label class="pure-radio">
						<input name="gender"  type="radio" value="male" checked>&nbsp;男
					</label>
					<label class="pure-radio">
						<input name="gender"  type="radio" value="femele" checked>&nbsp;女
					</label>
					
					<label>年齡:</label>
					<input name="age" type="number" min="1" max="150" required />
				
					<label>身高 (cm):</label>
					<input name="height" type="number" min="1" max="300" step="0.1" required />
					
					<label>體重 (kg):</label>
					<input name="weight" type="number" min="0.1" max="1000" step="0.1" required />
					
					<button type="submit" class="pure-form pure-form-primary">送出</button>
					
				</fieldset>
			</form>
		</div>
	</body>
</html>

