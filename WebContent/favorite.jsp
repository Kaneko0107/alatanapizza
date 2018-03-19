<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content="">
	<meta name="keywords" content=""/>
<title>お気に入りページ</title>


</head>
	<body>

		<jsp:include page="include_header.jsp" />

			<div class="main">


				<!-- お気に入りリストが空の場合 -->
				<div class="empty">

					<h3>お気に入りリスト</h3>

					<span style="color: red;"><s:property value="message" /></span>

					<s:if test="favoriteList.size()==0">
						<h4>お気に入りはありません。</h4>
					</s:if>

					<!-- お気に入りリストがある場合 -->
					<s:if test="favoriteList.size() > 0">
						<h4>お気に入り情報は以下になります。</h4>
						<p>&nbsp;&nbsp;</p>

						<s:form id="form" name="form" action="FavoriteAction">


						<s:iterator value="favoriteList">
							<!-- ここにsプロパティの値が詰まっている。元をたどるとfavoriteActionのList favoriteactionの
							記載のfavoriteDTOの変数名-->

							<div class="ph-box">


								<!-- チェックボックス作成 -->
								<div class="ph-check">
									<s:checkbox name="checkList" value="1" fieldValue="%{productId}" />
								</div>
										<!-- value=初期値でチェックされた状態　０にするとunchecked。0,1もしくはtrue,falseが入る。チェックボックス独特の書き方
										field valueはiteratorの時。どの商品をチェックしたのを情報として送信 -->

									<br><br>



								<!-- 画像を表示させる -->
								<div class="main_content clearfix_bon">
								<s:url id="url" action="ProductDetailsAction"><s:param name="product_id" value="productId" /></s:url>

								<s:a href="%{url}">
								  <img src='<s:property value="imageFilePath"/>' width="200" height="170" alt="Photo"/>
								</s:a>


								<s:hidden name="imageFileName" value='<s:property value="imageFileName"/>' />
								商品名:<span><s:property value="productName" /></span><br>


								<s:hidden name="productNameKana" value='<s:property value="productNameKana"/>' />
								商品名(かな):<span><s:property value="productNameKana" /></span><br>


								<s:if test="categoryId==2">
									金額(Mサイズ):<span>¥<s:property value="msizePrice" /></span><br>
									金額(Lサイズ):<span>¥<s:property value="lsizePrice" /></span><br>
								</s:if>


								<s:if test="categoryId==3 || categoryId==4">
									金額:<span>¥<s:property value="price" /></span><br>
									<s:hidden name="price" value="%{price}" />
								</s:if>



								<p>&nbsp;</p>
								<p>&nbsp;</p>
								<p>&nbsp;</p>

							</div>
						</s:iterator>

						<div class="delete">
							<s:submit value="削除"/>
							<s:hidden name="deleteFlg" value="1" />
						</div>



						</s:form>
					</s:if>
				</div>
			</div>
		<jsp:include page="include_footer.jsp" />
	</body>
</html>