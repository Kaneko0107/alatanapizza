<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
<link rel="stylesheet" href="./css/alatanapizza.css">


<title>商品一覧</title>
</head>
<body>

<!-- ヘッダーをインクルード  -->
<jsp:include page="include_header.jsp" />

<!------------------------------------------ 商品一覧ボタンを押した場合  --------------------------------------------------------->
	<!-- 表示件数1ページ目 -->
<table class="productList">
	<tr>
	<td>
	<s:iterator value="displayList">
	<div class="itemList">

				<a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
					<img class="image" src="<s:property value='image_file_path'/>" alt="Photo" width="200" height="170"><br>
				</a>
			<!-- 商品名 -->
				<s:property value="product_name" /><br>

			<!-- 商品かな -->
				<s:property value="product_name_kana" /><br>

			<!-- カテゴリーが2(ピザ)の場合の価格 -->
				<s:if test="category_id==2">
				<span>(M)</span>￥<s:property value="msize_price" />円 &nbsp<span>(L)</span>￥<s:property value="lsize_price" />円<br>
				</s:if>

			<!-- カテゴリーが3(サイド)の場合の価格 -->
				<s:if test="category_id==3"><br>
				￥<s:property value="price"/>円<br>
				</s:if>

			<!-- カテゴリーが4(ドリンク)の場合の価格 -->
				<s:if test="category_id==4"><br>
				￥<s:property value="price"/>円<br>
				</s:if>

			商品詳細:<s:property value="product_description" /><br>

				<a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
					<img class="image" src=./images/icon/modoru2.png><br>
				</a>

	</div>
	</s:iterator>
	</td>
	</tr>
</table>

<!-- リストにデータが入っている時-->
<s:if test="number > 8">
<s:if test="listFlg == 1">

<div class="center" style="text-align:center;">
						<!-- ページネーション:1ページ目のみ -->
						<s:if test="pageNum == 1">
						  <span>&laquo;<s:text name="戻る" /></span>
						</s:if>

						<!-- ページネーション:1ページ目以外 -->
						<s:else>
							<a href='<s:url action="ProductListAction">
							<s:param name="pageNum" value="pageNum-1"/>
							<s:param name="listFlg" value="listFlg"/>
							</s:url>'>&laquo;<s:text name="戻る" /></a>

						</s:else>


                        <s:property value="pageNum" />


						<!-- ページネーション:最終ページ -->
						<s:if test="pageNum == maxPage">
						<s:text name="進む" />&raquo;
						</s:if>


						<!-- 最終ページ以外 -->
						<s:else>
							<a href='<s:url action="ProductListAction">
							<s:param name="pageNum" value="pageNum+1"/>
							<s:param name="listFlg" value="listFlg"/>
							</s:url>'><s:text name="進む" />&raquo;</a>

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
			<span>ピザ</span>
		</s:if>
		<s:if test="categoryId == 3">
			<span>サイドメニュー</span>
		</s:if>
		<s:if test="categoryId == 4">
			<span>ドリンク</span>
		</s:if>
	</h1>


	<!-- 検索時のメッセージ -->
	<s:iterator value="msgList">
			<h1>検索キーワード "<s:property />"</h1>
	</s:iterator>
	<s:if test="number == 0">
			<h1>検索結果がありません。</h1>
	</s:if>

<table class="searchDTOList">
	<tr>
	<td>
	<s:iterator value="displaySearchList">
	<div class="itemList">

				<a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
					<img class="image" src="<s:property value='image_file_path'/>" alt="Photo" width="200" height="170"><br>
				</a>
			<!-- 商品名 -->
				<s:property value="product_name" /><br>

			<!-- 商品かな -->
				<s:property value="product_name_kana" /><br>

			<!-- カテゴリーが2(ピザ)の場合の価格 -->
				<s:if test="category_id==2">
				<span>(M)</span>￥<s:property value="msize_price" />円 &nbsp<span>(L)</span>￥<s:property value="lsize_price" />円<br>
				</s:if>

			<!-- カテゴリーが3(サイド)の場合の価格 -->
				<s:if test="category_id==3"><br>
				￥<s:property value="price"/>円<br>
				</s:if>

			<!-- カテゴリーが4(ドリンク)の場合の価格 -->
				<s:if test="category_id==4"><br>
				￥<s:property value="price"/>円<br>
				</s:if>

			商品詳細:<s:property value="product_description" /><br>

			<a href="<s:url action="ProductDetailsAction"><s:param name="product_id" value="%{product_id}" /></s:url>">
					<img class="image" src=./images/icon/modoru2.png><br>
				</a>

		</div>
	</s:iterator>
	</td>
	</tr>
</table>




<!-- リストにデータが入っている時-->
<s:if test="number > 8">
<s:if test="serachFlg == 1">

<div class="center" style="text-align:center;">
						<!-- ページネーション:1ページ目のみ -->
						<s:if test="pageNum == 1">
						  <span>&laquo;<s:text name="戻る" /></span>
						</s:if>

						<!-- ページネーション:1ページ目以外 -->
						<s:else>
							<a href='<s:url action="ProductSearchAction">
							<s:param name="pageNum" value="pageNum-1"/>
							<s:param name="searchWord" value="searchWord"/>
							<s:param name="categoryId" value="categoryId"/>
							<s:param name="serachFlg" value="serachFlg"/>
							</s:url>'>&laquo;<s:text name="戻る" /></a>

						</s:else>

                        <s:property value="pageNum" />

						<!-- ページネーション:最終ページ -->
						<s:if test="pageNum == maxPage">
						<s:text name="進む" />&raquo;
						</s:if>


						<!-- 最終ページ以外 -->
						<s:else>
							<a href='<s:url action="ProductSearchAction">
							<s:param name="pageNum" value="pageNum+1"/>
							<s:param name="searchWord" value="searchWord"/>
							<s:param name="categoryId" value="categoryId"/>
							<s:param name="serachFlg" value="serachFlg"/>
							</s:url>'><s:text name="進む" />&raquo;</a>

						</s:else>


</div>

</s:if>
</s:if>

<!-- フッターをインクルード -->
<jsp:include page="include_footer.jsp" />

</body>
</html>