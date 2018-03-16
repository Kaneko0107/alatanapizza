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
				<s:textfield placeholder="1文字以上16文字以下" name="familyName" value="%{familyName}" />
				<div>名</div>
				<s:textfield placeholder="1文字以上16文字以下" name="firstName" value="%{firstName}" />
				<div>姓(かな)</div>
				<s:textfield placeholder="1文字以上16文字以下" name="familyNameKana" value="%{familyNameKana}" />
				<div>名(かな)</div>
				<s:textfield placeholder="1文字以上16文字以下" name="firstNameKana" value="%{firstNameKana}" />
				<div>住所</div>
				<s:textfield placeholder="15文字以上50文字以下" name="userAddress" value="%{userAddress}" />
				<div>電話番号</div>
				<s:textfield placeholder="11文字以上13文字以下" name="telNumber" value="%{telNumber}" />
				<div>メールアドレス</div>
				<s:textfield placeholder="18文字以上32文字以下" name="email" value="%{email}" />
				<br>
				<s:submit value="登録情報確認画面へ"/>
			</s:form>

		</div>
		<a href="javascript:void(0)" onclick="javascript:history.back()">戻る</a>

<br>
<br>


	</div>
<jsp:include page="include_footer.jsp" />
</body>
</html>