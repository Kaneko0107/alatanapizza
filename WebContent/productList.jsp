<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="./css/product.css">
<link rel="stylesheet" href="./css/alatanapizza.css">

<title>商品一覧</title>
<style>
.top {
	width: 100%;
	text-align: center;
}

.list {
	width: 100%;
}
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./js/jquery-1.8.2.min.js"></script>
<script>
	$(function() {
		$(".imageHover .image").hover(function() {
			$(this).animate({
				width : "240px",
				height : "210px"
			});
		}, function() {
			$(this).animate({
				width : "200px",
				height : "170px"
			});
		});
	});
</script>


</head>
<body>

	<!-- ヘッダーをインクルード  -->
	<jsp:include page="include_header.jsp" />

	<!------------------------------------------ 商品一覧ボタンを押した場合  --------------------------------------------------------->
	<!-- 表示件数1ページ目 -->

	<s:iterator value="displayList">
		<div class="itemListBox">

			<div class="imageHover">
				<a
					href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
					<img class="image" src="<s:property value='image_file_path'/>"
					alt="Photo" width="200" height="170"><br>
				</a>
			</div>
			<div class="productInfo">
				<!-- 商品名 -->
				<div class="proName">
					<s:property value="product_name" />
					<br>
				</div>

				<!-- 商品かな -->

				<div class="proName2">
					<s:property value="product_name_kana" />
					<br>
				</div>

				<!-- カテゴリーが2(ピザ)の場合の価格 -->
				<div class="proName">
					<s:if test="category_id==2">
						<img class="image" src="./images/icon/m.png" alt="Photo">￥<s:property
							value="msize_price" />
						<br>
						<img class="image" src="./images/icon/l.png" alt="Photo">￥<s:property
							value="lsize_price" />
						<br>
					</s:if>

					<!-- カテゴリーが3(サイド)の場合の価格 -->
					<s:if test="category_id==3">
						<br>
				￥<s:property value="price" />
						<br>
					</s:if>

					<!-- カテゴリーが4(ドリンク)の場合の価格 -->
					<s:if test="category_id==4">
						<br>
				￥<s:property value="price" />
						<br>
					</s:if>
				</div>

					<a
						href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
						<img class="icon shousaiB" src=./images/icon/shousai.png><br>
					</a>

				</div>
			</div>

	</s:iterator>




	<!-- リストにデータが入っている時-->
	<s:if test="number > 8">
		<s:if test="listFlg == 1">

			<div class="center" style="text-align: center;">
				<!-- ページネーション:1ページ目のみ -->
				<s:if test="pageNum == 1">
					<span>&laquo;<s:text name="戻る" /></span>
				</s:if>

				<!-- ページネーション:1ページ目以外 -->
				<s:else>
					<a
						href='<s:url action="ProductListAction">
							<s:param name="pageNum" value="pageNum-1"/>
							<s:param name="listFlg" value="listFlg"/>
							</s:url>'>&laquo;<s:text
							name="戻る" /></a>

				</s:else>


				<s:property value="pageNum" />


				<!-- ページネーション:最終ページ -->
				<s:if test="pageNum == maxPage">
					<s:text name="進む" />&raquo;
						</s:if>


				<!-- 最終ページ以外 -->
				<s:else>
					<a
						href='<s:url action="ProductListAction">
							<s:param name="pageNum" value="pageNum+1"/>
							<s:param name="listFlg" value="listFlg"/>
							</s:url>'><s:text
							name="進む" />&raquo;</a>

				</s:else>


			</div>

		</s:if>
	</s:if>

	<!-------------------------------------------- 商品検索をした場合 ------------------------------------------->

	<h1>
		<s:if test="categoryId == 1">
			<span>全てのカテゴリ</span>
		</s:if>
		<s:if test="categoryId == 2">
			<span>Pizza</span>
		</s:if>
		<s:if test="categoryId == 3">
			<span>SideMenu</span>
		</s:if>
		<s:if test="categoryId == 4">
			<span>DrinkMenu</span>
		</s:if>
	</h1>


	<!-- 検索時のメッセージ -->
	<s:if test="searchWord.length() != 0">
		<s:iterator value="msgList">
			<h1>
				検索キーワード：
				<s:property />
			</h1>
		</s:iterator>
	</s:if>
	<s:if test="number == 0">
		<h1>検索結果がありません。</h1>
	</s:if>


	<s:iterator value="displaySearchList">
		<div class="itemList">
			<div class="itemListBox">

				<div class="imageHover">
				<a
					href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
					<img class="image" src="<s:property value='image_file_path'/>"
					alt="Photo" width="200" height="170"><br>
				</a>
			</div>
			<div class="productInfo">
				<!-- 商品名 -->
				<div class="proName">
					<s:property value="product_name" /><br>
				</div>

				<!-- 商品かな -->

				<div class="proName2">
					<s:property value="product_name_kana" /><br>
				</div>

				<!-- カテゴリーが2(ピザ)の場合の価格 -->
				<div class="proName">
					<s:if test="category_id==2">
						<img class="image" src="./images/icon/m.png" alt="Photo">￥<s:property
							value="msize_price" /><br>
						<img class="image" src="./images/icon/l.png" alt="Photo">￥<s:property
							value="lsize_price" /><br>
					</s:if>

					<!-- カテゴリーが3(サイド)の場合の価格 -->
					<s:if test="category_id==3"><br>
				￥<s:property value="price" /><br>
					</s:if>

					<!-- カテゴリーが4(ドリンク)の場合の価格 -->
					<s:if test="category_id==4">
						<br>
				￥<s:property value="price" /><br>
					</s:if>
				</div>

					<a
						href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
						<img class="icon shousaiB" src=./images/icon/shousai.png><br>
					</a>

				</div>
			</div>
			</div>

	</s:iterator>




	<!-- リストにデータが入っている時-->

	<div class="center" style="text-align: center;">
		<s:if test="number > 8">
			<s:if test="searchFlg == 1">


				<!-- ページネーション:1ページ目のみ -->
				<s:if test="pageNum == 1">
					<span>&laquo;<s:text name="戻る" /></span>
				</s:if>

				<!-- ページネーション:1ページ目以外 -->
				<s:else>
					<a
						href='<s:url action="ProductSearchAction">
							<s:param name="pageNum" value="pageNum-1"/>
							<s:param name="searchWord" value="searchWord"/>
							<s:param name="categoryId" value="categoryId"/>
							<s:param name="searchFlg" value="searchFlg"/>
							</s:url>'>&laquo;<s:text
							name="戻る" /></a>

				</s:else>

				<s:property value="pageNum" />

				<!-- ページネーション:最終ページ -->
				<s:if test="pageNum == maxPage">
					<s:text name="進む" />&raquo;
						</s:if>


				<!-- 最終ページ以外 -->
				<s:else>
					<a
						href='<s:url action="ProductSearchAction">
							<s:param name="pageNum" value="pageNum+1"/>
							<s:param name="searchWord" value="searchWord"/>
							<s:param name="categoryId" value="categoryId"/>
							<s:param name="searchFlg" value="searchFlg"/>
							</s:url>'><s:text
							name="進む" />&raquo;</a>

				</s:else><br><br>




			</s:if>
		</s:if>
		<a href="#"><i class="fa fa-chevron-up">ページの上に戻る</i></a>
	</div>

	<p class="top">

		<!-- フッター-->
		<jsp:include page="include_footer.jsp" />
</body>
</html>