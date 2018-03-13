<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
<title>クーポン表示画面</title>
</head>

<body>
	<div class="coupon-image">
		<img src="クーポン画像.PNG">
	</div>

	<h1>商品購入画面で、クーポンIDを入力いただくことで、クーポンをご利用いただけます。</h1><br>

	<div class="notification">
		<p>※次回ピザ購入時にのみご利用いただけます。サイドメニューにはご利用いただけません。</p><br>
		<p>※クーポンは初回のみ有効です</p>
	</div>

	<a href='<s:url action="ProductListAction"/>'>商品一覧画面へ</a>


</body>
</html>