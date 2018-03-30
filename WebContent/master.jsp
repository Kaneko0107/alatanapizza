<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css" />
<link rel="stylesheet" href="./css/master.css">

<title>管理者ページ</title>


</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />



	<fieldset>
		<legend>
			<h3>在庫数 変更方法</h3>

		</legend>
		<p>
			一度に変更できる個数は、在庫数±20個です。<br>
			個数を選択し <img class="image" src="./images/icon/master_stockchange.png" alt="icon">
			を押すと確定します。<br>
			最大在庫数は100個です。 <img class="image" src="./images/icon/tomato.png" alt="icon">
		</p>
		<p>
			<span style="color: yellow;"><s:property value="message" /></span>
		</p>
	</fieldset>
	<br>
	<br>
	<div id="main">
		<s:iterator value="productList">


			<div class="itemList">

				<p>
					<a
						href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
						<img class="image" src="<s:property value='image_file_path'/>"
						alt="Photo" width="200" height="170">
					</a>
				</p>
				<!-- 商品名 -->
				<p>
					<s:property value="product_name" />
				</p>

				<!-- 商品かな -->
				<p>
					<s:property value="product_name_kana" />
				</p>

				<!-- カテゴリーが2(ピザ)の場合の価格 -->
				<s:if test="category_id==2">
					<p>
						<span>(M)</span>￥
						<s:property value="msize_price" />
						&nbsp<span>(L)</span>￥
						<s:property value="lsize_price" />
					</p>
				</s:if>

				<!-- カテゴリーが3(サイド)の場合の価格 -->
				<s:if test="category_id==3">
					<p>
						￥
						<s:property value="price" />
					</p>
				</s:if>

				<!-- カテゴリーが4(ドリンク)の場合の価格 -->
				<s:if test="category_id==4">
					<p>
						￥
						<s:property value="price" />
					</p>
				</s:if>

				<s:form action="MasterProductChangeAction">
					<s:hidden name="productId" value="%{product_id}" />
				在庫:
				<s:select name="stock" list="%{productStockList.get(product_id)}"
						value="%{stock}" class="select1" />
					<s:submit value="在庫を変更する" class="submit" />
				</s:form>
			</div>


		</s:iterator>
	</div>

</body>
</html>