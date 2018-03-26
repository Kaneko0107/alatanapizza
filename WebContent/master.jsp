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

</style>

</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />

<h1>管理者ページ</h1>
		<div class="add">
		<span>商品追加は
					<a href='<s:url action="GoMasterAddAction"/>'>こちら</a>
			</span>
		</div>

		<!-- リストにデータが入っている時-->
	<s:if test="number > 8">
		<s:if test="listFlg == 1">

			<div class="center" style="text-align: center;">
				<!-- ページネーション:1ページ目のみ -->
				<s:if test="pageNum == 1">
					<span>&laquo;<s:text name="戻る" /></span>
				</s:if>

				<!-- ページネーション:1ページ目以外 -->
				<s:else>
					<a
						href='<s:url action="ProductListAction">
							<s:param name="pageNum" value="pageNum-1"/>
							<s:param name="listFlg" value="listFlg"/>
							</s:url>'>&laquo;<s:text
							name="戻る" /></a>

				</s:else>


				<s:property value="pageNum" />


				<!-- ページネーション:最終ページ -->
				<s:if test="pageNum == maxPage">
					<s:text name="進む" />&raquo;
						</s:if>


				<!-- 最終ページ以外 -->
				<s:else>
					<a
						href='<s:url action="ProductListAction">
							<s:param name="pageNum" value="pageNum+1"/>
							<s:param name="listFlg" value="listFlg"/>
							</s:url>'><s:text
							name="進む" />&raquo;</a>

				</s:else>

			</div>

		</s:if>
	</s:if>


	<span style="color: red;"><s:property value="errorMessage"/></span>


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

	<!-- リストにデータが入っている時-->
	<s:if test="number > 8">
		<s:if test="listFlg == 1">

			<div class="center" style="text-align: center;">
				<!-- ページネーション:1ページ目のみ -->
				<s:if test="pageNum == 1">
					<span>&laquo;<s:text name="戻る" /></span>
				</s:if>

				<!-- ページネーション:1ページ目以外 -->
				<s:else>
					<a
						href='<s:url action="ProductListAction">
							<s:param name="pageNum" value="pageNum-1"/>
							<s:param name="listFlg" value="listFlg"/>
							</s:url>'>&laquo;<s:text
							name="戻る" /></a>

				</s:else>


				<s:property value="pageNum" />


				<!-- ページネーション:最終ページ -->
				<s:if test="pageNum == maxPage">
					<s:text name="進む" />&raquo;
						</s:if>


				<!-- 最終ページ以外 -->
				<s:else>
					<a
						href='<s:url action="ProductListAction">
							<s:param name="pageNum" value="pageNum+1"/>
							<s:param name="listFlg" value="listFlg"/>
							</s:url>'><s:text
							name="進む" />&raquo;</a>

				</s:else>

			</div>

		</s:if>
	</s:if>

</body>
</html>