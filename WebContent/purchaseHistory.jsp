<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="./css/alatanapizza.css">
	<link rel="stylesheet" href="./css/cart.css">


<style>
.sort{
width:150px;
height:26px;
background-color: rgba(0, 0, 0, 0.7);
color:white;

}
.icon1{
width:100px;
height:26px;
background-color:red;
color:white;
border-radius:5px;
}

.icon1:hover{
opacity:0.8;
}


.icon2{
width:180px;
height:26px;
background-color: rgba(0, 0, 0, 0.7);
color:white;
border-radius:5px;

}

.icon2:hover{
opacity:0.8;
}

#boxList{
	height:40%;
}

</style>



<title>購入履歴</title>






</head>
<body>
	<jsp:include page="include_header.jsp" />

<br><br><br><br>
	<h2>注文履歴</h2>
	<span style="color: red;"><s:property value="message"/></span>
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
				<s:submit class="icon1" value="並び替え" />
			</s:form>
		</div>
		<!-- ---------------------------------- -->


<br><br>


			<s:form action="PurchaseHistoryAction">
				<input type="hidden" name="deleteFlg" value="2"/>

		<s:iterator value="historyList">
		<div id="boxList">

			<!-- チェックボックス,選択したものだけを削除 -->
			<label>
			<s:checkbox name="checkList" value="2" fieldValue="%{id}" />

			<!-- 購入日時 -->
			<s:property value="registDate" />
			</label>

			<!-- 画像 -->
			<div class="main_content">
				<div class="pizagazou">
					<a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{productId}" /></s:url>">
						<img class="image" src="<s:property value='imageFilePath'/>"
						alt="Photo" width="200" height="170"></a><br>
				</div>


				<!-- 商品名 -->
				<s:property value="productName" />
				<br>
				<!-- 商品かな -->
				<s:property value="productNameKana" />
				<br>

			</div>

			<!-- 金額 -->
			<div class="price_count">
				<div class="price"><span>金額:¥</span><s:property value="price" /></div>
				<br>
				<div class="count">(購入数:<s:property value="count" />点)</div>
			</div>

		</div>
		</s:iterator>

		<!--  ■削除ボタン■ -->
		<p id="delete">
			<s:submit class="icon2" value="チェックした項目を削除" /></p>
		</s:form>

		<span class="all_delete">
			<s:form action="PurchaseHistoryAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit class="icon2" value="履歴をすべて削除" />
			</s:form>
		</span>

	</s:elseif>

	<a href='<s:url action="MyPageAction" />'>◀　マイページに戻る</a>
	<br>
		<a href="#"><i class="fa fa-chevron-up">ページの上に戻る</i></a>


	<jsp:include page="include_footer.jsp" />
</body>

</html>