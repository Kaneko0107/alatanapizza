<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="UTF-8">
	<title>alatanapizza検索結果</title>

</head>

<body class="home">


<!-- メインコンテンツ -->
<div class="top_main clearfix">
			<h1>
				<s:if test="categoryId == 1">
					<span>全てのカテゴリ</span>
				</s:if>
				<s:if test="categoryId == 2">
					<span>ピザ</span>
				</s:if>
				<s:if test="categoryId == 3">
					<span>サイドメニュー</span>
				</s:if>
				<s:if test="categoryId == 4">
					<span>ドリンク</span>
				</s:if>
			</h1>

		<s:iterator value="msgList">
			<h1>検索キーワード "<s:property />"</h1>
		</s:iterator>
		<s:if test="searchDTOList.size()==0">
			<h1>検索結果がありません。</h1>
		</s:if>
	<table class="productList">
	<tr>
	<td>
	<s:iterator value="searchDTOList">
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

				<s:form action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" />
				<s:submit value="注文に進む"/>
				</s:form>

		</div>
	</s:iterator>
	</td>
	</tr>
</table>
</div>
</body>