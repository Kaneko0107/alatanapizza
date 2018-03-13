<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />

<title>商品詳細画面</title>

	<style type="text/css">
		body {
		   margin:0;
		   padding:0;
		   line-height:2.0;
		   letter-spacing:1.5px;
		   font-family:arial black, Helvetica, sans-serif;
		   font-size:15px;
		   color:white;
		   text-align:center;
		   background-color:black;
			background-image:url("./images/icon/background.jpg");
			background-size:cover;
			background-repeat: no-repeat;
		}
		h2{
			border-left:solid red 20px;
		}
		table {
			margin:0 27% 0 27%;
		}
		#category{
			text-align:left;
			font-size:30px;
		}
		#productName{
			 font-size:25px;
			 border-bottom: double 5px red;
		}
		#productNameKana{
			 font-size:20px;
		}
		#productPrice{
			font-size:20px;
		}
		.productDescription{
			position: relative;
			 margin: 2em auto;
 			padding: 1.5em;
 			border: 1px solid white;
 			width: 80%;
		}
		.productDescription .productDescription1 {
			 position: absolute;
 			padding: 0 .5em;
 			left: 1em;
			 top: -1em;
 			content: "";
 			font-weight: bold;
		}
		#toppingtitle{
			text-align:left;
			line-height:0.5;
			 font-size:20px;
		}
		.line {
  			height: 0.5px;
 			 border : dashed 0.3px;
 			 margin:0 20% 0 20%;
		}
	#suggestProduct{
		text-align:left;
		font-size:20px;
	}
	#suggest{
		float:left;
	}

	</style>

<!--
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
						 //+ $("#select").val();
		var idx = obj.options[idx].value;
		var text = obj.options[idx].text;
		alert(idx);
		alert(text);
		console.log('value= ' + value + ',' + 'text= ' + text);
	}
</script>
-->

</head>
<body>



	<s:form action="GoCartAction" name="select">


	<table class="detailsTable">
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
						<img class="image"
							src="<s:property value='session.d_image_file_path'/>" alt="Photo"
							width="400" height="300">
					</span>
			</td>
			<td>
							<span id="productName">
								<!-- 商品名 -->
								<s:property value="session.d_product_name" /></span><br>
							<span id="productNameKana">
								<!-- 商品名かな -->
								<s:property value="session.d_product_name_kana" /></span>
								<br>

						<!-- カテゴリーによって値段表示変更 -->
						<span id="productPrice">
						<s:if test="session.d_category_id==2">
							<input type="radio" name="optionsRadios"
								id="Radio1" value="1" onChange="culcItemSize();">M￥<s:property
									value="session.d_product_msize_price" />
							<input type="radio" name="optionsRadios"
								id="Radio2" value="1" onChange="culcItemSize();">L￥<s:property
									value="session.d_product_lsize_price" />
						</s:if>
						<s:if test="session.d_category_id==3 || session.d_category_id==4">
						<!-- サイド・ドリンク -->
							￥<s:property value="session.d_product_price" />
						</s:if></span>

							<div class="productDescription">
							<div class="productDescription1">商品詳細</div>
							<s:property value="session.d_product_description" /></div>
			</td>
			</tr>
	</table><br>


<s:if test="session.d_category_id==2">
	<table class="topping">
		<tr>
		<th>
		<div id="toppingtitle">
			Topping ￥324</div>
		</th>
		</tr>
		<tr>
		<td>
		<div class="productDescription">

						<s:iterator value="session.toppingList" status="topping-number">
								<input type="checkbox" id='topping-number"<s:property value='#topping-number.count'/>"' value="<s:property value='msize_price'/>"  onclick="calcTotal();" />
								<s:property value="topping_name" />
						</s:iterator></div>
		</td>
		</tr>
	</table>
</s:if><br><br>



			数量
			<s:select name="product_count" list="stockList"
				onchange="outputSelectedValueAndText(this);" />
			選択した商品の金額
			<s:textfield name="productDetailPrice" id="productDetailPrice" />



			<s:hidden name="gocart" value="1" />
			<s:submit value="カートに入れる" />

	</s:form><br><br>

	<hr class="line"><br>


	<table class="suggestProduct">
		<tr>
		<th>
			<span id="suggestProduct">
				その他おすすめ商品</span>
		</th>
		</tr>

			<s:iterator value="suggestList">
		<div id="suggest">
		<tr>
		<td>

				<a href="<s:url action="ProductDetailsAction">
				 <s:param name="product_id" value="%{product_id}" /></s:url>">
						<img class="image" src="<s:property value='image_file_path'/>
						" alt="Photo" width="250" height="200">
				</a>

		</td>
		</tr>
		<tr>
		<td>
								<s:property value="product_name" />
								<s:property value="product_name_kana" />
		</td>
		</tr>
		<tr>
		<td>
							<s:if test="category_id==2">
								M￥<s:property value="msize_price" />
								L￥<s:property value="lsize_price" />
							</s:if>
							<s:if test="category_id==3 || category_id==4">
								￥<s:property value="price" />
							</s:if>
						<s:hidden name="product_id" value="%{product_id}" />
		</td>
		</tr>
		</div>
		</s:iterator>

	</table>



</body>
</html>