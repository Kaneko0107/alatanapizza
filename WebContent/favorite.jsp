<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<link rel="stylesheet" href="./css/alatanapizza.css">
	<link rel="stylesheet" href="./css/cart.css">

<title>お気に入りページ</title>


</head>
	<body>

		<jsp:include page="include_header.jsp" />

			<div class="main">



				<div class="empty">
					<h3>お気に入り</h3>

					<!-- すでにその商品がお気に入りにあった場合のメッセージ -->
					<span style="color: red;"><s:property value="message" /></span>

					<!-- お気に入りリストが空の場合 -->
					<s:if test="favoriteList.size()==0">
						<h4>お気に入りはありません。</h4>
					</s:if>

					<!-- お気に入りリストがある場合 -->
					<s:if test="favoriteList.size() > 0">
						<h4>お気に入り情報は以下になります。</h4>

						<s:form id="form" name="form" action="FavoriteAction">

						<s:iterator value="favoriteList">
							<div id="boxList">
							<!-- ここにsプロパティの値が詰まっている。
							元をたどるとfavoriteActionのList favoriteactionの記載のfavoriteDTOの変数名-->

							<div class="ph-box">

								<!-- チェックボックス作成 -->
								<div class="ph-check">
									<s:checkbox name="checkList" value="1" fieldValue="%{productId}" />
								</div>
										<!-- value=初期値でチェックされた状態　０にするとunchecked。0,1もしくはtrue,falseが入る。
										チェックボックス独特の書き方field valueはiteratorの時。どの商品をチェックしたのを情報として送信 -->

								<!-- 商品情報 -->
								<div class="main_content clearfix_bon">
								<s:url id="url" action="ProductDetailsAction"><s:param name="product_id" value="productId" /></s:url>
								<s:a href="%{url}">
								  <img src='<s:property value="imageFilePath"/>' width="200" height="170" alt="Photo"/>
								</s:a><br>

								<s:hidden name="imageFileName" value='<s:property value="imageFileName"/>' />
								<span><s:property value="productName" /></span><br>

								<s:hidden name="productNameKana" value='<s:property value="productNameKana"/>' />
								<span><s:property value="productNameKana" /></span><br>

								<s:if test="categoryId==2">
									M<span>¥<s:property value="msizePrice" /></span>&nbsp;
									L<span>¥<s:property value="lsizePrice" /></span><br>
								</s:if>

								<s:if test="categoryId==3 || categoryId==4">
									<span>¥<s:property value="price" /></span><br>
									<s:hidden name="price" value="%{price}" />
								</s:if>

								<br><br><a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
									<img class="image" src=./images/icon/shousai.png><br>
								</a>

							</div>
						</div>
					</div>
				</s:iterator>

						<div id="delete">
							<s:submit value="削除"/>
							<s:hidden name="deleteFlg" value="1" />
						</div>

						</s:form>
					</s:if>
				</div>
			</div>


			<a href='<s:url action="ProductListAction?listFlg=1"/>'>商品一覧画面に戻る</a><br><br>


		<jsp:include page="include_footer.jsp" />
	</body>
</html>