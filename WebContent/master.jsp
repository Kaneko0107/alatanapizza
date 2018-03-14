<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者画面です</title>
</head>
<body>

<h1>管理者画面です</h1>

	<span style="color: red;"><s:property value="errorMessage"/></span>

<table class="productList">
	<tr>
	<td>
	<s:iterator value="productList">
	<div class="itemList">

				<a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
					<img class="image" src="<s:property value='image_file_path'/>" alt="Photo" width="200" height="170"><br>
				</a>
			<!-- 商品名 -->
				<s:property value="product_name" /><br>

			<!-- 商品かな -->
				<s:property value="product_name_kana" /><br>

			<!-- カテゴリーが2(ピザ)の場合の価格 -->
				<s:if test="category_id==2">
				<span>(M)</span>￥<s:property value="msize_price" />円 &nbsp<span>(L)</span>￥<s:property value="lsize_price" />円<br>
				</s:if>

			<!-- カテゴリーが3(サイド)の場合の価格 -->
				<s:if test="category_id==3"><br>
				￥<s:property value="price"/>円<br>
				</s:if>

			<!-- カテゴリーが4(ドリンク)の場合の価格 -->
				<s:if test="category_id==4"><br>
				￥<s:property value="price"/>円<br>
				</s:if>

			商品詳細:<s:property value="product_description" /><br>

				<s:form action="MasterProductChangeAction">
				<s:hidden name="productId" value="%{product_id}" />
				在庫:
				<s:textfield name="stock" value="%{stock}"></s:textfield>
				<s:submit value="在庫を変更する"/>
				</s:form>

		</div>
	</s:iterator>
	</td>
	</tr>
		<div>
		<span>商品追加は
					<a href='<s:url action="MasterAddAction"/>'>こちら</a>
			</span>
		</div>
</table>
</body>
</html>