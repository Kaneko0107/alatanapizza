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
<title>alatanapizza 宛先情報登録画面</title>
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
			<div style="color: red;" ><s:property value="errorMessageList"/></div>
			<h3>新規宛先情報入力</h3>
			<h3>下記に必要事項を記入してください</h3>
			<s:form action="DestConfirmAction">
				<div>姓</div>
				<s:textfield name="familyName" value ="%{familyName}" />
				<div>名</div>
				<s:textfield name="firstName" value ="%{firstName}"/>
				<div>姓ふりがな</div>
				<s:textfield name="familyNameKana" value ="%{familyNameKana}"/>
				<div>名ふりがな</div>
				<s:textfield name="firstNameKana" value ="%{firstNameKana}"/>
<!--				<div>性別</div>
				<label><input type="radio" name="sex" value="男" checked />男</label>
				<label><input type="radio" name="sex" value="女"  />女</label>-->
				<div>住所</div>
				<s:textfield name="userAddress" value ="%{userAddress}"/>
				<div>電話番号</div>
				<s:textfield name="telNumber" value ="%{telNumber}"/>
				<div>メールアドレス</div>
				<s:textfield name="email" value ="%{email}"/>
				<s:submit value="登録情報確認画面へ"/>
			</s:form>
		</div>


	</div>
<jsp:include page="include_footer.jsp" />
</body>
</html>