<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品詳細画面</title>

</head>
<body>

<!--商品情報 -->
<div class="main">
		<h3><!-- ボタンの名前 --></h3>
		<div class="DetailsList">
			<div class="detailsList">
				<div class="img">
					<img class="image"
						src="<s:property value='session.d_image_file_path'/>" alt="Photo"
						width="300" height="240">
				</div>
				<table class="detailsTable">
					<tr>
						<td class="nowrap"><!-- 商品名 --></td>
						<td><s:property value="session.d_product_name" /></td>
					</tr>
					<tr>
						<td class="nowrap"><!-- 商品名かな --></td>
						<td><s:property value="session.d_product_name_kana" /></td>
					</tr>
					<tr>
						<td class="nowrap">M</td>
						<td>￥<s:property value="session.d_product_price" />
						</td>
						<td class="nowrap">L</td>
						<td>￥<s:property value="session.d_product_price" />
						</td>
					</tr>
					<tr>
						<td class="nowrap">商品詳細</td>
						<td>:</td>
						<td><s:property value="session.d_product_description" /></td>
					</tr>
				</table>
			</div>
		</div>

		<h5>トッピング</h5>
		<div class="ToppingList">
			<div class="toppingList">
			<table class="toppingTable">
					<tr>
						<td class="nowrap"><!-- 商品名 --></td>
						<td><s:property value="session.d_product_name" /></td>
					</tr>


			</table>
			</div>
		</div>

</div>

</body>
</html>