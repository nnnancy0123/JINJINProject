<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.jinjinshop.www.object.ProductObj"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>JIN JIN SHOP</title>
</head>

<body style="background-color: #F5FFFA;">
	<legend>JINJIN SHOPPING </legend>
	<script>
		function show() {
			var date = new Date();
			var now = "";
			now = date.getFullYear() + "年";
			now = now + (date.getMonth() + 1) + "月";
			now = now + date.getDate() + "日";
			now = now + date.getHours() + "時";
			now = now + date.getMinutes() + "分";
			document.getElementById("nowDiv").innerHTML = now;
			setTimeout("show()", 1000);
		}
	</script>
<body onload="show()">
	<div id="nowDiv"></div>
	<hr />
	<!--管理ボタン-->
	<button type="button" class="btn" style="background-color: #7FB5F9">
		新規</button>
	<button type="button" class="btn " style="background-color: #7FB5F9">編集</button>
	<button type="button" class="btn " style="background-color: #7FB5F9">削除</button>
	<button type="button" class="btn" style="background-color: #7FB5F9">リフレッシュ</button>
<form action="/JINJINProject/ProductController" method="get">

	<!--横情報-->
	<table class="table table-success table-striped">
		<thead>
			<tr>
				<th scope="col">商品ID</th>
				<th scope="col">価格</th>
				<th scope="col">概要</th>
				<th scope="col">モデル</th>
				<th scope="col">カテゴリー</th>
				<th scope="col">ブランド</th>
				<th scope="col">生産地</th>
				<th scope="col">在庫</th>

			</tr>
		</thead>
		<tbody>
		<%
List<ProductObj> list = (List<ProductObj>) request.getAttribute("List");
%>
			<%
			for (ProductObj p : list) {
			%>
			<tr>
				<td><%=p.getProductId()%></td>
				<td><%=p.getProductName()%></td>
				<td><%=p.getImformation()%></td>
				<td><%=p.getModel()%></td>
				<td><%=p.getCategory()%></td>
				<td><%=p.getBrand()%></td>
				<td><%=p.getProducingArea()%></td>
				<td><%=p.getCategory()%></td>
				<td><%=p.getBrand()%></td>
				<td><%=p.getProducingArea()%></td>
				<td><%=p.getStockpileNum()%></td>
			</tr>
			<%
			}
			%> 
		</tbody>
	</table>
	</form>
</body>
</html>