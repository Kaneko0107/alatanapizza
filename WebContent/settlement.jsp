<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 金額、日付表示カスタムタグ -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/alatanapizza.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>決済確認画面</title>
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
							<s:a href="%{url}">

								<!-- ふりがな表示 -->
								<div class="kana">
									<s:property value="productNameKana" />
								</div>

								<!-- 商品名表示 -->
								<div class="pro_name">
									商品名：
									<s:property value="productName" />
								</div>
							</s:a>
						</div>
						<s:property value="toppings" />

						<!-- 商品説明 -->
						<div class="pro_namesetumei">
							<!-- 商品詳細 -->
							商品詳細:
							<s:property value="productDescription" />
							<br>

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

							<!-- 発売会社 -->
							<div class="company">
								発売会社：
								<s:property value="releaseCompany" />
							</div>

							<!-- 年月日 -->
							<div class="release_date">
								発売日：
								<s:property value="releaseDate" />
							</div>
						</div>


					</div>
				</div>
			</s:iterator>

			<br>
			<br>
			<div class="totalprice">
				合計金額:¥
				<s:property value="totalPrice" />

			</div>
			<br>

			<!-- --------------------■宛先情報■--------------------- -->
			<s:iterator value="destinationListDTO">
				<div class="box">
					<div class="destination_title">
						<label> <input type="radio" name="id" checked="checked" />
							お届け先住所
						</label>
					</div>
					<div class="destination">
						ふりがな:
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
			</s:iterator>


			<div class="btn">
				<input type="button" value="宛先情報の新規登録"
					onclick="location.href='<s:url action="DestAction" />'">
			</div>
			<div class="btn_2">
				<s:submit value="購入" class="submit " />


			</div>
		</s:form>
		<div class="back">
		<a href='<s:url action="CartProductAction" />'>カートに戻る</a>
	</div>
	</div>
	<br>
	<br>


	<div>
		<jsp:include page="include_footer.jsp" /></div>

</body>
</html>


