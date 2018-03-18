<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="include_header.jsp" />

	<h2>注文履歴</h2>
	<s:if test="historyList.size() == 0">
		<p>購入履歴はありません</p>
	</s:if>
	<s:elseif test="historyList != null && historyList.size() != 0">

		<p>購入情報は以下になります。</p>

		<div>
			<!-- ■並び替えのプルダウン■ -->
			<s:form action="PurchaseHistoryAction">
				<select class="sort" name="sort">
					<option selected value="1">注文日 新しい順</option>
					<option value="2">値段 高い順</option>
					<option value="3">値段 安い順</option>
				</select>
				<s:submit value="並び替え" />
			</s:form>
		</div>
		<!-- ---------------------------------- -->


		<!--  ■全て削除のボタン■ -->

		<div class="all_delete">
			<s:form action="PurchaseHistoryAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="履歴をすべて削除" />
			</s:form>
		</div>
		<s:submit value="個別削除 " name="checkFlg" fieldValue="%{id}" />
		<!-- --------------------- -->





		<!-- ■購入履歴一覧表示■ -->
		<s:iterator value="historyList">

			<!-- チェックボックス -->
			<s:checkbox name="checkFlg" value="2" fieldValue="%{id}" />

			<!-- 選択したものだけを削除 -->



			<!-- 画像 -->
			<div class="main_content">
				<div class="pizagazou">
					<a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{productId}" /></s:url>">
						<img class="image" src="<s:property value='imageFilePath'/>"
						alt="Photo" width="200" height="170"></a><br>
				</div>


				<!-- 商品名 -->
				商品名:<s:property value="productName" />
				<br>

				<!-- 商品かな -->
				商品名 かな:<s:property value="productNameKana" />
				<br>

				<!-- 商品詳細 -->
				商品詳細:
				<s:property value="productDescription" />
				<br>

			</div>

			<!-- 金額 -->
			<div class="price_count">
				<div class="price"><span>金額:\</span><s:property value="price" /></div>
				<br>
				<div class="count">(購入数:<s:property value="count" />点)</div>
			</div>

		</s:iterator>

	</s:elseif>
	<a href='<s:url action="MyPageAction" />'>マイページに戻る</a>
	<br>
	<p id="pageTop">
		<a href="#"><i class="fa fa-chevron-up">ページトップに戻る</i></a>
	</p>

	<jsp:include page="include_footer.jsp" />
</body>

</html>