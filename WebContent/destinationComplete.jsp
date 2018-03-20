<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content="">
<meta name="keywords" content=""/>
<title>alatanapizza 宛先情報登録完了画面</title>
<style type="text/css">
/*========TAG LAYOUT========*/
/*========ID LAYOUT========*/
</style>
</head>
<body>
<jsp:include page="include_header.jsp" />
	<div id="main">
		<div id="top">
		</div>
		<div>
			<h3></h3>
			<h3>登録が完了しました</h3>

		</div>

		<span></span>
		<a href='<s:url action="BuyItemCompleteAction"/>'>購入画面へ</a>


	</div>
<jsp:include page="include_footer.jsp" />
</body>
</html>