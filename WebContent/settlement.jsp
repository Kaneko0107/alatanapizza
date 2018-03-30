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
<link rel="stylesheet" href="./css/settlement.css">

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

								<img src='<s:property value="imageFilePath"/>' width="200"
									height="170" alt="画像なし" />


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
							<!-- ピザサイズ表示 -->
							<s:property value="pizzaSize"/>サイズ

						</div>


					</div>
				</div>
			</s:iterator>

			<br>
			<br>
			<div class="totalprice">
				カート合計¥
				<s:property value="totalPrice" />
<s:submit type="image" class="icon2" value="" src="./images/icon/order.png"/>
			</div>
			<br>
			<div id="btn_2">
			<div class="btn_2">

			</div></div>
		</s:form>

		<!-- --------------------■宛先情報■--------------------- -->



<div class="adress">
		<h2>お届け先の選択</h2>
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
					</div><br>
					<div class="destination">
						ふりがな:

						<s:property value="familyNameKana" />
						<s:property value="firstNameKana" />
						<br> 名前:
						<s:property value="familyName" />
						<s:property value="firstName" />
						<br> 郵便番号:
						<s:property value="zip11" />
						<br> 住所:
						<s:property value="addr11" />
						<br> 電話番号:
						<s:property value="telNumber" />
						<br> メールアドレス:
						<s:property value="email" />
						<br><br><br>
					</div>
				</div>

			</s:iterator>


		<!-- 宛先新規登録 -->
<div class="atesaki">
		<input type="button" class="icon1" value="宛先情報の新規登録"
			onclick="location.href='<s:url action="DestAction" />'"></div>


			<!-- 宛先個別削除 -->

			<s:submit class="icon1" value="選択している宛先を削除" />
			<input type="hidden" name="deleteFlg" value="2" /></s:form>


		<!-- 宛先全削除 -->
		<div class="atesaki">
		<s:form action="DestinationDeleteAction">
			<input type="hidden" name="deleteFlg" value="1">
			<s:submit class="icon1" value="宛先をすべて削除" />
		</s:form></div><br></div>



<br><br>
	<h2>こちらの商品も一緒にいかがですか？</h2>
	<br>
	<br>
<p class="recomend">
	<s:iterator value="notSameCategoryList">
	<div id="nscl">

		<a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">

		<img class="image" src="<s:property value='image_file_path'/> " alt="Photo" style="max-width: 250px; max-height: 200px;">
		</a>

							<div>
								<s:property value="product_name" /><br>
								<s:property value="product_name_kana" /><br>

								<s:if test="category_id==2">
									M￥<s:property value="msize_price" />&nbsp;
									L￥<s:property value="lsize_price" />
								</s:if>
								<s:if test="category_id==3 || category_id==4">
									￥<s:property value="price" />
								</s:if>
								<s:hidden name="product_id" value="%{product_id}" />

								<br><br><a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
									<img class="image" src=./images/icon/shousai.png><br>
								</a>
							</div>


		</div>
	</s:iterator>

	</p>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div class="memo">
	<a href='<s:url action="CartProductAction" />'>◀ カートに戻る</a></div>

<a href="#"><i class="fa fa-chevron-up">ページの上に戻る</i></a>
	<div class="memo"><a href='<s:url action="HomeAction"/>'>ホーム</a></div>
	<div>
		<jsp:include page="include_footer.jsp" /></div>

</body>
</html>


