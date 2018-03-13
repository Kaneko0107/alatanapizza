<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>決済確認画面</title>
</head>
<body>
	<!--<jsp:include page="include_header.jsp" />-->

<!-- ------------------■main■ ----------------------------->
<div class="main">
	<br>
	<h2 class="title">注 文 確 認</h2>
	<br>

	<s:form action="PurchaseCompleteAction">
		<p class="message">購入情報は以下になります</p>
		<br>

	<s:iterator value="cartList">
		<div class="border">
		</div>

		<!-- 画像 -->
		<div class="main_content clearfix_kudo" style="overflow: hidden;">

			<div class="pro_img">
				<s:url id="url" action="ProDetailAction"><s:param name="id" value="productId" /></s:url>
					<s:a href="%{url}">
						<img src='<s:property value="image_file_name"/>' alt="画像なし"/>

					</s:a>
			</div>

			<div class="pro_text">
				<div class="name">
					<s:url id="url" action="ProDetailAction"><s:param name="id" value="productId" /></s:url>
						<s:a href="%{url}">
							<!-- ふりがな -->
							<div class="kana">
								<s:property value="product_name_kana" />
							</div>

							<!-- 商品名 -->
							<div class="name">
								商品名:<s:property value="product_name" />
							</div>
						</s:a>
				</div>


			<div class="price_count">
		    	<!-- 値段 -->
		    	<div class="price">
					価格:\<fmt:formatNumber value="${price}" />
				</div>

				<!-- 個数 -->
				<div class="count">
					(購入数:  <s:property value="productCount" />点)
				</div>
			</div>


		</div>
		</div>
	</s:iterator>
		<div class="border">
		</div>

		<br>
		<br>
		<div class="totalprice">
			合計金額:\
			<fmt:formatNumber value="${totalPrice}" />
		</div>
		<br>

		<!-- --------------------宛先情報--------------------- -->
		<s:iterator value="destinationInfoListDTO">
			<div class="box">
				<div class="destination_title">
					<label>
						<input type="radio" name="id" checked="checked"/>
						お届け先住所
					</label>
				</div>
				<div class="destination_box">
					ふりがな:
					<s:property value="familyNameKana"/>
					<s:property value="firstNameKana"/>
					<br>
					名前:
					<s:property value="familyName"/>
					<s:property value="firstName"/>
					<br>
					住所:
					<s:property value="userAddress"/>
					<br>
					電話番号:
					<s:property value="telNumber"/>
					<br>
					メールアドレス:
					<s:property value="email"/>
					<br>
				</div>
			</div>
		</s:iterator>

		<div class="box_2">
			<div class="btn_1">
				<input type="button" value="宛先情報の新規登録"
				onclick="location.href='<s:url action="GoDestinationRegisterAction" />'">
			</div>
			<div class="btn_2">
				<button type="submit">購入</button>
			</div>
		</div>
	</s:form>
</div>
<br>
<br>

		<div class= "back">
			<a href='<s:url action="GoCartAction" />'>カートに戻る</a>
		</div>


<!-- メインここまで -->

	<!--<jsp:include page="include_footer.jsp" /></span>-->

</body>
</html>


