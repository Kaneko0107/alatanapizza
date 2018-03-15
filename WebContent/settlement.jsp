<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- 金額、日付表示カスタムタグ -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

			<!-- ここからまわすよー！ -->
			<s:iterator value="cartList">

				<!-- 画像 -->
				<div class="main_content" style="overflow: hidden;">

					<div class="img">
						<s:url id="url" action="ProductDetailsAction">
							<s:param name="id" value="productId" />
						</s:url>
						<s:a href="%{url}">
							<img src='<s:property value="imageFilePath"/>' alt="画像なし" />

						</s:a>
					</div>

					<div class="pro_text">
						<div class="name">
							<s:url id="url" action="ProductDetailsAction">
								<s:param name="id" value="productId" />
							</s:url>
							<s:a href="%{url}">
								<!-- 商品名 -->
								<s:property value="product_name" />
								<br>

								<!-- 商品かな -->
								<s:property value="product_name_kana" />
								<br>
							</s:a>

							商品詳細:<s:property value="product_description" /><br>

						</div>


						<div class="price_count">
							<!-- 値段 -->
							<div class="price">
								価格:\

							</div>

							<!-- 個数 -->
							<div class="count">
								(購入数:
								<s:property value="productCount" />
								点)
							</div>
						</div>


					</div>
				</div>
			</s:iterator>

			<br>
			<br>
			<div class="totalprice">
				合計金額:\

			</div>
			<br>

			<!-- --------------------■宛先情報■--------------------- -->
			<s:iterator value="DestinationDTO">
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
	</div>
	<br>
	<br>

	<div class="back">
		<a href='<s:url action="CartProductAction" />'>カートに戻る</a>
	</div>
	<div>
		<jsp:include page="include_footer.jsp" /></div>

</body>
</html>


