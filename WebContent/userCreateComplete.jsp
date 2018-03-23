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

	<title>ユーザー登録 完了</title>
</head>


<body>
	<jsp:include page="include_header.jsp" />
	<div id="main">
	<div class="form-user-regist">

	<table>

	<tr><td colspan="2"><h3>ユーザー登録 完了</h3></td></tr>
	<tr><td colspan="2"><div class="moji2">ありがとうございます</div></td></tr>
	<tr><td colspan="2"><hr></td></tr>

	<tr>
		<td><a href='<s:url action="LoginAction"/>'><img src="./images/icon/ログイン.png"></a></td>
	</tr>

	</table>
	</div>
	</div>

	<jsp:include page="include_footer.jsp" />
</body>
</html>