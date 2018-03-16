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
			<span style="color: red;" ><s:property value="errorMessageList"/></span>
			<h3>新規宛先情報入力</h3>
			<h3>下記に必要事項を記入してください</h3>
			<s:form action="DestConfirmAction">
				<span>姓</span>
				<s:textfield name="familyName" value ="%{familyName}"/>
				<span>名</span>
				<s:textfield name="firstName" value ="%{firstName}"/>
				<span>姓ふりがな</span>
				<s:textfield name="familyNameKana" value ="%{familyNameKana}"/>
				<span>名ふりがな</span>
				<s:textfield name="firstNameKana" value ="%{firstNameKana}"/>
				<span>性別</span>
				<label><input type="radio" name="sex" value="男" checked />男</label>
				<label><input type="radio" name="sex" value="女"  />女</label>
				<span>住所</span>
				<s:textfield name="userAddress" value ="%{userAddress}"/>
				<span>電話番号</span>
				<s:textfield name="telNumber" value ="%{telNumber}"/>
				<span>メールアドレス</span>
				<s:textfield name="email" value ="%{email}"/>
				<s:submit value="登録情報確認画面へ"/>
			</s:form>
		</div>


	</div>
<jsp:include page="include_footer.jsp" />
</body>
</html>