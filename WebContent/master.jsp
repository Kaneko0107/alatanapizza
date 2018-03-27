<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<link rel="stylesheet" href="./css/alatanapizza.css">

<title>管理者ページ</title>

<style type="text/css">
.itemList{
	float:left;
	width:32.5%;
}
.add{
	clear:both;

}

h1{
	margin-top:50px;
	margin-left:130px;
}

h3{
color:white;}


.select1{
width:50px;
height:22px;
background-color: rgba(0, 0, 0, 0.7);
color:white;
}

.submit{
width:120px;
height:25px;
font-size:13px;
background-color:gray;
color:white
}

fieldset{
	width: 30%;
	background: rgba(0, 0, 0, 0.5);
	margin:0 auto;
	margin;top:30px;
	margin-bottom:30px;
}

img.example1 {
width: 96px;
height: 65px;
}

</style>

</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />


<fieldset>
<legend>
<h3>在庫数 変更方法</h3>

</legend>
一度に変更できる個数は、在庫数±20個です。<br>
個数を選択し
<img class="image" src="./images/icon/master_stockchange.png" alt="icon"> を押すと確定します。<br>
0個～100個内で変更できます。
<img class="image" src="./images/icon/tomato.png" alt="icon">
</fieldset>

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
				<span>(M)</span>￥<s:property value="msize_price" /> &nbsp<span>(L)</span>￥<s:property value="lsize_price" /><br>
				</s:if>

			<!-- カテゴリーが3(サイド)の場合の価格 -->
				<s:if test="category_id==3">
				￥<s:property value="price"/><br>
				</s:if>

			<!-- カテゴリーが4(ドリンク)の場合の価格 -->
				<s:if test="category_id==4">
				￥<s:property value="price"/><br>
				</s:if>

				<s:form action="MasterProductChangeAction">
				<s:hidden name="productId" value="%{product_id}" />
				在庫:
				<s:select name="stock" list="%{productStockList.get(product_id)}" value="%{stock}" class="select1" />
				<s:submit value="在庫を変更する" class="submit"/>
				</s:form>

		</div>
	</s:iterator>

</body>
</html>