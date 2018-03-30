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
<title>宛先情報登録 完了</title>
<script type="text/javascript">
window.onunload=function(){};
history.forward();
</script>
<style type="text/css">
/*========TAG LAYOUT========*/

/*========ID LAYOUT========*/
</style>
</head>

<header>
	<jsp:include page="include_header.jsp" />
</header>

<body>

	<div id="main">

		<div>
			<h3></h3>
			<h3>登録が完了しました</h3>

		</div>

		<a href='<s:url action="BuyItemCompleteAction"/>'>購入画面へ</a>


	</div>

</body>

<footer>
	<jsp:include page="include_footer.jsp" />
</footer>

</html>