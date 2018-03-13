<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>商品詳細画面</title>

<script src="./js/jquery-1.12.4.min.js">
	//ピザM,Lサイズ選択のラジオボタン
	$(function() {
		$('input[name="optionsRadios"]:radio').change(function() {
			var radioval = $(this).val();
			if (radioval == 1) {
				$('#inputother').removeAttr('disabled');
			} else {
				$('#inputother').attr('disabled', 'disabled');
			}
		});
	});

</script>

<script type="text/javascript">
//ピザM,Lサイズボタンに値段を持たせる
function culcItemSize(){
	MsizePrice = form1.Radio1.checked;
	LsizePrice = form1.Radio2.checked;
	alert(MsizePrice);
	alert(LsizePrice);
	var data = document.select.product_count.value;
	if(MsizePrice == true ){
		document.getElementById("productDetailPrice").value = data
					+ (<s:property value="session.s_product_msize_price"/>);
	}
	if(LsizePrice == true ){
		document.getElementById("productDetailPrice").value = data
		+ (<s:property value="session.s_product_lsize_price"/>);
	}
}
</script>

<script>
//トッピングのチェックボックスに番号をつけて合計数を計算
function culcTotal(){
	var data = document.select.product_count.value;
	check1 = document.select.topping-number1.checked;
	check2 = document.select.topping-number2.checked;
	check3 = document.select.topping-number3.checked;
	check4 = document.select.topping-number4.checked;
	check5 = document.select.topping-number5.checked;
	check6 = document.select.topping-number6.checked;
	check7 = document.select.topping-number7.checked;
	check8 = document.select.topping-number8.checked;
	check9 = document.select.topping-number9.checked;
	check10 = document.select.topping-number10.checked;
	check11 = document.select.topping-number11.checked;
	check12 = document.select.topping-number12.checked;

	//	toppingTotalPrice = (check1+check2+check3+check4+check5+check6+check7+check8+check9+check10+check11+check12);
}
</script>

<script>
	function outputSelectedValueAndText(obj) {
		var data = document.select.product_count.value;
		//商品詳細合計の計算
		document.getElementById("productDetailPrice").value = data
						* ((<s:property value="session.s_product_msize_price"/> + <s:property value="s_product_lsize_price"/> + <s:property value="s_product_price"/>)
						+culcTotal()) //+ $("#select").val();
		var idx = obj.options[idx].value;
		var text = obj.options[idx].text;
		alert(idx);
		alert(text);
		console.log('value= ' + value + ',' + 'text= ' + text);
	}
</script>


</head>
<body>



	<s:form action="GoCartAction" name="select">
		<span class="main">
			<!-- カテゴリーの表示 -->
			<s:if test="session.d_category_id==2">
			<h1>Pizza</h1>
			</s:if>
			<s:if test="session.d_category_id==3">
			<h1>SideMenu</h1>
			</s:if>
			<s:if test="session.d_category_id==4">
			<h1>DrinkMenu</h1>
			</s:if>

			<!-- 画像の表示 -->
			<span class="DetailsList">
				<span class="detailsList">
					<span class="img">
						<img class="image"
							src="<s:property value='session.d_image_file_path'/>" alt="Photo"
							width="400" height="270">
					</span>

					<table class="detailsTable">
						<tr>
							<th class="nowrap">
								<!-- 商品名 --><h2>
								<s:property value="session.d_product_name" /></h2></th>
							<td class="nowrap">
								<!-- 商品名かな -->
							</td>
							<td><s:property value="session.d_product_name_kana" /></td>
						</tr>

						<!-- カテゴリーによって値段表示変更 -->
						<tr><form name="form1" action="">
						<s:if test="session.d_category_id==2">
							<td><input type="radio" name="optionsRadios"
								id="Radio1" value="1" onChange="culcItemSize();">M￥<s:property
									value="session.d_product_msize_price" /></td>
							<td><input type="radio" name="optionsRadios"
								id="Radio2" value="1" onChange="culcItemSize();">L￥<s:property
									value="session.d_product_lsize_price" /></td>
						</s:if>
						<s:if test="session.d_category_id==3 || session.d_category_id==4">
						<td class="nowrap"><!-- サイド・ドリンク --></td>
							<td>￥<s:property value="session.d_product_price" /></td>
						</s:if></form>
						</tr>

						<tr>
							<td class="nowrap">商品詳細</td>
							<td>:</td>
							<td><s:property value="session.d_product_description" /></td>
						</tr>

					</table>
				</span>
			</span>

			<h3>トッピング</h3>
			<h4>M￥324,L￥432</h4>
			<!--<span class="ToppingList">-->
				<span class="toppingList">
					<table class="toppingTable">
						<s:iterator value="session.toppingList" status="topping-number">

								<input type="checkbox" id='topping-number"<s:property value='#topping-number.count'/>"' value="<s:property value='msize_price'/>"  onclick="calcTotal();" />
								<s:property value="topping_name" />

						</s:iterator>
					</table>
				</span>
			<!--</span>-->



			数量
			<s:select name="product_count" list="stockList"
				onchange="outputSelectedValueAndText(this);" />
			選択した商品の金額
			<s:textfield name="productDetailPrice" id="productDetailPrice" />



			<s:hidden name="gocart" value="1" />
			<s:submit value="カートに入れる" />


		</span>
	</s:form>


	<h2>その他おすすめ商品</h2>
	<div>
		<div class="thumbnail clearFix">
			<s:iterator value="suggestList">
				<a
					href="<s:url action="ProductDetailsAction">
				 <s:param name="product_id" value="%{product_id}" />
 			</s:url>">
					<div class="list1">
						<img class="image"
							src="<s:property value='image_file_path'/>" alt="Photo"
							width="250" height="200">
						<table class="detailsTable">
							<tr>
								<td class="nowrap"><!-- 商品名 --></td>
								<td><s:property value="product_name" /></td>
								<td class="nowrap"><!-- 商品かな --></td>
								<td><s:property value="product_name_kana" /></td>
							</tr>

							<tr>
							<s:if test="category_id==2">
								<td class="nowrap">M</td>
								<td>￥<s:property value="msize_price" />
								<td class="nowrap">L</td>
								<td>￥<s:property value="lsize_price" />
								<td class="nowrap">
								</td>
							</s:if>
							<s:if test="category_id==3 || category_id==4">
								<td>￥<s:property value="price" />
								</td>
							</s:if>
							</tr>
						</table>
						<s:hidden name="product_id" value="%{product_id}" />

					</div>
				</a>
			</s:iterator>
		</div>
	</div>



</body>
</html>