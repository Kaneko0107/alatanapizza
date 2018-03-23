<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 金額、日付表示カスタムタグ -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/alatanapizza.css">
<link rel="stylesheet" href="./css/cart.css">

<script type="text/javascript">
	window.onunload = function() {
	};
	history.forward();
</script>

<title>決済確認</title>
</head>
<body>
	<jsp:include page="include_header.jsp" />

	<!-- ------------------■main■ ----------------------------->
	<div class="main">
		<br>
		<h2 class="title">注 文 確 認</h2>
		<br>

		<s:form action="PurchaseCompleteAction">
			<p class="message">購入情報は以下になります</p>
			<br>

			<!-- CartListをイテレーター！ -->
			<s:iterator value="cartList">
				<div id="boxList">

					<!-- 画像 -->
					<div class="main_content" style="overflow: hidden;">

						<div class="img">
							<s:url id="url" action="ProductDetailsAction">
								<s:param name="product_id" value="productId" />
							</s:url>
							<s:a href="%{url}">
								<img src='<s:property value="imageFilePath"/>' width="200"
									height="170" alt="画像なし" />

							</s:a>
						</div>


						<!-- テキストデータを表示させる -->
						<div class="pro_text">
							<div class="name">
								<!-- 商品名表示 -->
								<div class="pro_name">
									<s:property value="productName" />
								</div>
								<!-- ふりがな表示 -->
								<div class="kana">
									<s:property value="productNameKana" />
								</div>
							</div>
							<s:if test="toppings.isEmpty()">
							<span> </span>
							</s:if>
							<s:else>
							トッピング:<s:iterator value="toppings"><s:property/> </s:iterator>
							</s:else>

							<!-- 値段表示 -->
							<div class="price_count"></div>
							<div class="price">
								<%-- 価格:¥<fmt:formatNumber value="${price}" /> --%>
								価格:¥
								<s:property value="price" />
							</div>

							<!-- 個数表示 -->
							<div class="count">
								（購入数：
								<s:property value="productCount" />
								点）
							</div>

						</div>


					</div>
				</div>
			</s:iterator>

			<br>
			<br>
			<div class="totalprice">
				カート合計¥
				<s:property value="totalPrice" />

			</div>
			<br>
			<div class="btn_2">
				<s:submit value="購入" class="submit " />


			</div>
		</s:form>

		<!-- --------------------■宛先情報■--------------------- -->




		<p id="dL">お届け先の選択</p>
		<s:form action="DestinationDeleteAction">
			<s:iterator value="destinationListDTO" status="st">


				<div class="box">
					<div class="destination_title">
						<label>
							<s:if test="#st.index == 0">
								<input type="radio" name="id" checked="checked" value="<s:property value='id'/>"/>
							</s:if><s:else>
								<input type="radio" name="id" value="<s:property value='id'/>"/>
							</s:else>
							お届け先住所
						</label>
					</div>
					<div class="destination">
						ふりがな:
						<s:property value="id" />
						<s:property value="familyNameKana" />
						<s:property value="firstNameKana" />
						<br> 名前:
						<s:property value="familyName" />
						<s:property value="firstName" />
						<br> 住所:
						<s:property value="userAddress" />
						<br> 電話番号:
						<s:property value="telNumber" />
						<br> メールアドレス:
						<s:property value="email" />
						<br>
					</div>
				</div>


				<!-- 宛先個別削除 -->
			</s:iterator>
			<s:submit class="submit" value="削除" />
			<input type="hidden" name="deleteFlg" value="2" />
		</s:form>

		<%-- <s:form action="DestinationDeleteAction"> --%
<%-- 				<a href='<s:url action="DestinationDeleteAction"> --%>
		<%-- 				<s:param  name="deleteFlg" value="2"></s:param></s:url>'>削除</a> --%>
		<%-- 				</s:form> --%>









		<!-- 宛先全削除 -->
		<s:form action="DestinationDeleteAction">
			<input type="hidden" name="deleteFlg" value="1">
			<s:submit class="submit" value="宛先をすべて削除" />
		</s:form>

		<!-- 宛先新規登録 -->
		<input type="button" class="submit" value="宛先情報の新規登録"
			onclick="location.href='<s:url action="DestAction" />'">
		<div class="back">

			<a href='<s:url action="CartProductAction" />'>◀ カートに戻る</a>
		</div>
	</div>
	<br>
<!-- 	<div style="margin-top: 100px;"> -->
<!-- 	おすすめ商品 -->
<!-- 	<ul> -->
<%-- 	<s:iterator value="notSameCategoryList"> --%>
<!-- 		<li> -->
<!-- 		<a -->
<%-- 			href="<s:url action="BuyItemCompleteAction"> --%>
<%-- 									 <s:param name="category_id" value="%{category_id}" /></s:url>"> --%>
<!-- 		</a> -->

<%-- 		<s:property value="session.notSameCategoryList.productName" /> --%>

<%-- 		<s:property value="productName" /> --%>
<%-- 		<s:property value="product_name" /> --%>
<%-- 		<s:property value="product_name_kana" /> --%>
<!-- 		</li> -->
<%-- 	</s:iterator> --%>
<!-- 	</ul> -->
<!-- 	</div> -->
	<div>
		<jsp:include page="include_footer.jsp" /></div>

</body>
</html>


