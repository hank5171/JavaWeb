<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品列表管理</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		
		<style>
			#preview {
				margin-top: 10px;
				max-width: 200px;
				max-height: 200px;
				border: 1px solid #ddd;
				padding: 5px;
			}
			
			.button-error{
            	color: white;
            	border-radius: 4px;
            	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
        	}
        	
       		.button-error {
           		background: rgb(202, 60, 60);
           		/* this is a maroon */
        	}
        	
			.word {
   				text-align: center;
    			vertical-align: middle;  /* 垂直置中 */
			}
		</style>
		
	</head>
	<body>
		<!-- menu bar -->
		<%@ include file="/WEB-INF/view/cart/menu.jsp"  %>
		<!-- content -->
		<div style="padding: 15px" class="pure-form">
			<table>
				<td valign="top">
					<fieldset>
						<legend>商品表單</legend>
						<form enctype="multipart/form-data" method="post" action="/javaweb/product/add">
							商品名稱：<input type="text" id="productName" name="productName" required="true"><p />
							商品價格：<input type="number" id="price" name="price" required="true" min="1" max="200"><p />
							商品庫存：<input type="number" id="qty" name="qty" required="true" min="1" max="999999"><p />
							商品照片：<input type="file" id="productImage" name="productImage" required="true"><p />
							<img id="preview" alt="照片預覽" style="display: none;" /><p />
							<button type="submit">新增商品</button>
						</form>
					</fieldset>	
				</td>
				<td valign="top">
					<fieldset>
						<legend>商品列表</legend>
						<table class="pure-table">
							<thead>
								<tr>
									<th>商品ID</th><th>商品名稱</th><th>商品價格</th>
									<th>商品庫存</th><th>庫存成本</th><th>商品照片</th>
									<th>刪除</th>
								</tr>
							</thead>
							<tbody>
								<!-- 商品列表 -->
								<c:forEach var="productDTO" items="${ productDTOs }">
						    		<tr onmouseover="this.style.backgroundColor='#E0E0ff'" 
									    onmouseout="this.style.backgroundColor=''">
						        		<td class="word">${ productDTO.productId }</td>
						        		<td class="word">${ productDTO.productName }</td>
						        		<td class="word">${ productDTO.price }</td>
						    	        <td class="word">${ productDTO.qty }</td>
						        		<td class="word">${ productDTO.total }</td>
						        		<td>
						        			<img width="100" src="${empty productDTO.imageBase64 ? '' : 'data:image/png;base64,' + productDTO.imageBase64}" />
						        		</td>
						        		<td><a class= "button-error pure-button" href="/JavaWebCart/product/delete?productId=${ productDTO.productId }">X</a></td>
						        		
						   			</tr>
								</c:forEach>		
							</tbody>
						</table>
					</fieldset>
				</td>
			</table>
			
		</div>
		
		<script>
		    document.getElementById('productImage').addEventListener('change', function(event) {
		        const fileInput = event.target;
		        const file = fileInput.files[0];
		        const fileName = file?.name || ''; // 獲取檔案名稱
		        const regex = /^.(\d+)([^\d].*[^\d])(\d+)\.png$/; // 假設格式為 任意字元<庫存數字><商品名稱><價格>.png
		        const match = fileName.match(regex);

		        if (match) {
		            const [_, qty, name, price] = match; // 解構正則匹配的結果
		            document.getElementById('qty').value = qty; // 庫存數字
		            document.getElementById('productName').value = name;  // 商品名稱
		            document.getElementById('price').value = price; // 商品價格
		        } else {
		            //alert('檔名格式不符合規範，請使用正確格式！');
		            document.getElementById('qty').value = '';
		            document.getElementById('productName').value = '';
		            document.getElementById('price').value = '';
		        }

		        // 預覽照片
		        if (file) {
		            const reader = new FileReader();
		            reader.onload = function(e) {
		                const preview = document.getElementById('preview');
		                preview.src = e.target.result; // 將讀取的圖片內容設定為 img 的 src
		                preview.style.display = 'block'; // 顯示圖片
		            };
		            reader.readAsDataURL(file); // 讀取檔案內容
		        } else {
		            document.getElementById('preview').style.display = 'none'; // 如果沒有圖片則隱藏預覽
		        }
		    });
		</script>
		
	</body>
</html>