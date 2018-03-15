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



<div class="main">


<!-- お気に入りリストが空の場合 -->
	<div class="empty">

	<h3>お気に入りリスト</h3>

	<s:if test="favoriteList.size()==0">
		<h4>お気に入りはありません。</h4>
	</s:if>

<!-- お気に入りリストがある場合 -->
	<s:if test="favoriteList.size() > 0">
		<h4>お気に入り情報は以下になります。</h4>
		<p>&nbsp;&nbsp;</p>

	<s:form id="form" name="form" action="FavoriteAction">
		<table border="0" cellspacing="0">

			<s:iterator value="favoriteList">
			<!-- ここにsプロパティの値が詰まっている。元をたどるとfavoriteActionのList favoriteactionの
			記載のfavoriteDTOの変数名-->

			<div class="ph-box">


<!-- チェックボックス作成 -->
				<div class="ph-check">
					<s:checkbox name="checkList" value="1"
							fieldValue="%{productId}" />
				</div>
				<!-- value=初期値でチェックされた状態　０にするとunchecked。0,1もしくはtrue,falseが入る。チェックボックス独特の書き方
				field valueはiteratorの時。どの商品をチェックしたのを情報として送信 -->

<br><br>

					<div class="iFP"><img src="<s:property value='imageFilePath'/>" width="auto" height="200px"></div>
						<s:hidden name="imageFilePath" value='<s:property value="imageFilePath"/>' />



					<s:hidden name="imageFileName" value='<s:property value="imageFileName"/>' />
					商品名:<span><s:property value="productName" /></span><br>

					金額:<span><s:property value="price" /></span><br>
					<s:hidden name="price" value="%{price}" />

					発売会社名:<span><s:property value="releaseCompany" /></span><br>
					<s:hidden name="releaseCompany" value="%{releaseCompany}" />

					発売年月日:<span><s:property value="releaseDate" /></span><br>
					<s:hidden name="id" value="%{id}"/>

					<s:hidden name="releaseDate" value="%{releaseDate}" />
					<s:hidden name="productId" value="%{productId}" />

	<p>&nbsp;</p>
	<p>&nbsp;</p>
<p>&nbsp;</p>

					</div>
			</s:iterator>




			<div class="delete23">
				<s:submit value="削除"/>
						<s:hidden name="deleteFlg" value="1" />
					</div>


		</table>
	</s:form>

</s:if>

</div>
</div>












</body>
</html>