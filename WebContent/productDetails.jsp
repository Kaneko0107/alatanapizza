<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<link rel="stylesheet" href="./css/alatanapizza.css">
	<link rel="stylesheet" href="./css/product.css">

<title>商品詳細画面</title>
<style type="text/css">

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="./js/jquery-3.3.1.min.js"></script>
  <script src="./js/jquery-1.8.2.min.js"></script>
    <script>
    	//合計金額計算式
        $(function() {
            $('input[name="product"]:radio').change(function() {
                var product_val = $('input[name="product"]:checked').val();
                if(product_val == window.undefined){
                    product_val = $('#sAndDPrice').attr("value") || "0";
                }
                var count = $('#topping input:checkbox:checked').length;
                var topping_price = parseInt(count) * 324;
                var product_menu_count = $('[name="productCount"]').val();
                var total_price = (parseInt(product_val) + parseInt(topping_price)) * parseInt(product_menu_count);
                $('input[name="total_price"]').val(total_price);
                $('#total_price_text').text(total_price);
            });
            $('.topping_menu').change(function() {
                var product_val = $('input[name="product"]:checked').val();
                if(product_val == window.undefined){
                    product_val = $('#sAndDPrice').attr("value") || "0";
                }
                var count = $('#topping input:checkbox:checked').length;
                var topping_price = parseInt(count) * 324;
                var product_menu_count = $('[name="productCount"]').val();
                var total_price = (parseInt(product_val) + parseInt(topping_price)) * parseInt(product_menu_count);
                $('input[name="total_price"]').val(total_price);
                $('#total_price_text').text(total_price);
            });
            $('#product_count').change(function() {
                var product_val = $('input[name="product"]:checked').val();
                if(product_val == window.undefined){
                    product_val = $('#sAndDPrice').attr("value") || "0";
                }
                var count = $('#topping input:checkbox:checked').length;
                var topping_price = parseInt(count) * 324;
                var product_menu_count = $('[name="productCount"]').val();
                var total_price = (parseInt(product_val) + parseInt(topping_price)) * parseInt(product_menu_count);
                $('input[name="total_price"]').val(total_price);
                $('#total_price_text').text(total_price);
            });
            $(function() {
                var product_val = $('input[name="product"]:checked').val();
                if(product_val == window.undefined){
                    product_val = $('#sAndDPrice').attr("value") || "0";
                }
                var count = $('#topping input:checkbox:checked').length;
                var topping_price = parseInt(count) * 324;
                var product_menu_count = $('[name="productCount"]').val();
                var total_price = (parseInt(product_val) + parseInt(topping_price)) * parseInt(product_menu_count);
                $('input[name="total_price"]').val(total_price);
                $('#total_price_text').text(total_price);
            });
            $('#sAndDPrice').change(function() {
            	var sAndDPrice = sAndDPrice_val();
            	var product_menu_count = $('[name="productCount"]').val();
            	var total_price = parseInt(sAndDPrice_val) * parseInt(product_menu_count);
          	  $('input:text[name="total_price"]').val(sAndDPrice);
        	});
        });
    </script>

</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="include_header.jsp" />

		<%--お気に入りボタン,非ログイン時は非表示 --%>
		<div class="f">
		<s:if test="#session.containsKey('userId')">
			<s:form action="FavoriteAction">
				<span class="favlist" >
					<input type=hidden name=favoriteInsertFlg value="1" />
					<input type=hidden name=product_id value='<s:property value="product_id"/>' />
					<input type="image"  src=./images/icon/hart.png alt="お気に入り登録">
				</span><span class="favcomment">お気に入りに登録</span>
			</s:form>
		</s:if></div>

	<s:form action="CartProductAction" name="select">

	<table class="detailsTable" >
		<tr>
		<th>
			<span id="category">
			<!-- カテゴリーの表示 -->
				<s:if test="session.d_category_id==2">
					<h2>Pizza</h2>
				</s:if>
				<s:if test="session.d_category_id==3">
					<h2>SideMenu</h2>
				</s:if>
				<s:if test="session.d_category_id==4">
					<h2>DrinkMenu</h2>
				</s:if>
			</span>
		</th>
		</tr>

		<!-- 画像の表示 -->
		<tr>
		<td>
			<span id="img">
				<img class="image" src="<s:property value='session.d_image_file_path'/>" alt="Photo" style="max-width: 400px; max-height: 300px;">
			</span>
		</td>
		<td>
			<!-- 商品名 -->
			<span id="productName" >
				<s:property value="session.d_product_name" /></span><br>
			<!-- 商品名かな -->
			<span id="productNameKana">
				<s:property value="session.d_product_name_kana" /></span><br>

			<!-- カテゴリーによって値段表示変更 -->
				<span class="formProduct">
					<s:if test="session.d_category_id==2">
						<p class="product_menu_size">
							<label><input type="radio" name="product" checked="checked" value='<s:property value="session.d_product_msize_price" />'><img class="image" src="./images/icon/m.png" alt="Photo" >￥<s:property value="session.d_product_msize_price" /></label>&nbsp;
							<label><input type="radio" name="product" value='<s:property value="session.d_product_lsize_price" />'><img class="image" src="./images/icon/l.png" alt="Photo" >￥<s:property value="session.d_product_lsize_price" /></label>
					</s:if>
					<s:if test="session.d_category_id==3 || session.d_category_id==4">
						<!-- サイド・ドリンク -->
						<input type="hidden" id="sAndDPrice" name="sAndDPrice" value="<s:property value="session.d_product_price" />">￥<s:property value="session.d_product_price" />
					</s:if></span>

					<fieldset>
						<legend>商品詳細</legend>
							<s:property value="session.d_product_description" /></fieldset>
		</td>
		</tr>
	</table><br>


	<s:if test="session.d_category_id==2">
		<table class="table-topping">
			<tr>
			<th>
			<div id="toppingtitle">
				Topping ￥324</div>
			</th>
			</tr>
			<tr>
			<td>
				<div class="productDescription">
					<span id="topping">
						<s:iterator value="session.toppingList" status="topping-number">
							<label><input type="checkbox" name="topping_id_<s:property value='topping_id'/>" value="<s:property value='msize_price'/>" class="topping_menu"  />
							<s:property value="topping_name" /></label>
						</s:iterator>
					</span>
				</div>
			</td>
			</tr>
		</table>
	</s:if>


	<p id="total1">
		<s:if test="stockList.size() != 0">
		Quantity:
			<s:select name="productCount" id="product_count" list="stockList"
				onchange="outputSelectedValueAndText(this);" />&nbsp;
		Total:￥
			<s:hidden name="total_price" id="total_price" />
				<span id="total_price_text"></span>&nbsp;
					<s:hidden name="productId" value="%{session.d_product_id}" ></s:hidden>
					<s:hidden name="gocart" value="1" />
					<input type="image" src=./images/icon/gocart.png alt="カートに入れる">

		</s:if>
		<s:if test="stockList.size() == 0">
			申し訳ありません。ただいま売り切れ中で購入できません。
		</s:if>
	</p>
	</s:form>

		<a href='<s:url action="ProductListAction?listFlg=1"/>'>商品一覧画面に戻る</a><br><br>



	<hr class="line"><br>



		<div id="sP">
			<h3 id="suggestProduct">
				その他おすすめ商品</h3>
					<s:iterator value="suggestList">
						<div id="suggest">
							<div>
								<a href="<s:url action="ProductDetailsAction">
									 <s:param name="product_id" value="%{product_id}" /></s:url>">
										<img class="image" src="<s:property value='image_file_path'/> " alt="Photo" style="max-width: 250px; max-height: 200px;">
								</a>
							</div>
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
		</div><br>


	<!-- フッター-->
	<jsp:include page="include_footer.jsp" />


</body>
</html>