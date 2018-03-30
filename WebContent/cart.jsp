<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="./css/alatanapizza.css">
<link rel="stylesheet" href="./css/cart.css">

<title>カート画面</title>

<style>
.icon3 {
	position: relative;
	top: 9px;
}

.icon3:hover {
	opacity: 0.8;
}
</style>

</head>
<body>
	<jsp:include page="include_header.jsp" />


	<div class="main">

		<h1>カート</h1>
		<s:if test="errorMessageList.size() > 0">
			<ul>
				<s:iterator value="errorMessageList">
					<li style="float: none;"><span style="color: red;"><s:property /></span></li>
				</s:iterator>
			</ul>
		</s:if>
		<s:if test="cartList.isEmpty()">
			<p class="eMessage">カートの中は空です</p>
		</s:if>
		<s:else>
			<p class="message">カートには以下の商品が入っています</p>

			<s:iterator value="cartList">

				<div id="boxList">
					<!-- 画像を表示させる -->
					<div class="main_content clearfix_bon">
						<s:url id="url" action="ProductDetailsAction">
							<s:param name="product_id" value="productId" />
						</s:url>

						<s:a href="%{url}">
							<img src='<s:property value="imageFilePath"/>' width="200"
								height="170" alt="Photo" />
						</s:a>

						<!-- テキストデータを表示させる -->
						<div class="pro_text">
							<div class="name">

								<!-- 商品名表示 -->
								<div class="pro_name">
									<s:property value="productName" />
								</div>
							</div>

							<!-- ふりがな表示 -->
							<div class="kana">
								<s:property value="productNameKana" />
							</div>

							<s:if test="toppings.isEmpty()">
								<span> </span>
							</s:if>
							<s:else>
							トッピング:<s:iterator value="toppings">
									<s:property />
								</s:iterator>
							</s:else>


							<!-- 値段表示 -->
							<div class="price_count"></div>
							<div class="price">
								価格¥
								<s:property value="price" />
							</div>

							<!-- 個数表示 -->
							<div class="count">
								（購入数：<s:property value="productCount" />点）
							</div>

							<!-- ピザサイズ表示 -->
							<s:property value="pizzaSize" />
							サイズ

							<!-- 削除ボタン -->
							<div class="deletebutton">
								<s:form action="CartDeleteAction">
									<a href='<s:url action="CartDeleteAction">
							<s:param name="id" value="id"></s:param></s:url>'>削除</a>
								</s:form>
								<!-- 商品詳細ボタン -->
								<a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="productId"/></s:url>">
									<img class="icon" src=./images/icon/shousai.png><br>
								</a>
							</div>
						</div>
					</div>
				</div>
			</s:iterator>


			<div class="border"></div>
			<!-- 合計金額の表示 -->
			<div class="totalprice">
				合計金額:¥
				<s:property value="totalPrice" />
				<s:if test="! cartList.isEmpty()">

					<a href='<s:url action ="BuyItemCompleteAction" />'><img
						class="icon3" src="./images/icon/決済画面.png"></a>
				</s:if>
			</div>
		</s:else>
	</div>


	<div class="settlement_btn">
		<a href='<s:url action ="ProductListAction?listFlg=1" />'>商品一覧画面へ</a>
	</div>

	<div class="settlement_btn">
		<a href='<s:url action ="HomeAction" />'>ホーム画面へ</a>
	</div>

	<!-- F5キー（画面の更新）とBackspaceとDeleteの無効化 -->
	<script>
		$(function() {
			$(document).keydown(function(event) {
				//クリックされたキーコードを取得する
				var keyCode = event.keyCode;

				//F5の場合はfalseをリターン
				if (keyCode == 116) {
					console.log("F5");
					return false;
				}
				//バックスペースキーを制御する
				if (keyCode == 8) {
					console.log("Backspace");
					return false;
				}
				//デリートキーを制限する
				if (keyCode == 46) {
					console.log("Delete");
					return false;
				}
			})
		});
	</script>

	<jsp:include page="include_footer.jsp" />
</body>
</html>