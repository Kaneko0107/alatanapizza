<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link rel="stylesheet" href="./css/alatanapizza.css">

<title>新商品追加 完了</title>

<style type="text/css">
</style>
</head>


<body>

	<jsp:include page="include_header.jsp" />


	<div id="main">
		<div id="top"></div>

		<div>
			<h3>新商品の追加が完了しました</h3>
		</div>
	</div>

	<a href='<s:url action="MasterProductChangeAction"/>'>管理者HOME画面へ戻る</a>

	<jsp:include page="include_footer.jsp" />

</body>
</html>