<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>

	<link rel="stylesheet" href="./css/alatanapizza.css">
	<link rel="stylesheet" href="./css/userAdd.css">
	<link rel="stylesheet" href="./css/userComplete.css">

	<title>ユーザー登録 完了</title>

</head>


<body>
	<jsp:include page="include_header.jsp" />
	<div id="main">
	<div id="maincom">
	<div class="form-user-regist">

	<table>

	<tr><td><h3>ユーザー登録 完了</h3></td>
	<tr>
	<td colspan="2"><div class="moji2">ご登録ありがとうございます</div></td></tr>
	<tr>
	<td colspan="2"><hr></td></tr>
<tr>


		<td><div class="icon5"><a href='<s:url action="LoginAction"/>'><img class="icon5" src="./images/icon/ログイン.png"></a></div></td>
	</tr>

	</table>
	</div>
	</div>
	</div>

	<jsp:include page="include_footer.jsp" />
</body>
</html>