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
<title>alatanapizza 宛先情報確認画面</title>
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
			<h3>以下の内容で登録します</h3>
			<table>
			<s:form action="DestCompleteAction">
				<div>姓</div>
				<s:property value="familyName" escape="false"/>
				<input type=hidden name="familyName" value='<s:property value="familyName"/>' />
				<div>名</div>
				<s:property value="firstName" escape="false"/>
				<input type=hidden name="firstName" value='<s:property value="firstName"/>' />
				<div>姓ふりがな</div>
				<s:property value="familyNameKana" escape="false"/>
				<input type=hidden name="familyNameKana" value='<s:property value="familyNameKana"/>' />
				<div>名ふりがな</div>
				<s:property value="firstNameKana" escape="false"/>
				<input type=hidden name="firstNameKana" value='<s:property value="firstNameKana"/>' />
				<div>住所</div>
				<s:property value="userAddress" escape="false"/>
				<input type=hidden name="userAddress" value='<s:property value="userAddress"/>' />
				<div>電話番号</div>
				<s:property value="telNumber" escape="false"/>
				<input type=hidden name="telNumber" value='<s:property value="telNumber"/>' />
				<div>メールアドレス</div>
				<s:property value="email" escape="false"/>
				<input type=hidden name="email" value='<s:property value="email"/>' />

				<s:submit value="登録情報確定画面へ"/>
			</s:form>
			</table>
		</div>

<a href="javascript:void(0)" onclick="javascript:history.back()">戻る</a>


	</div>
<jsp:include page="include_footer.jsp" />
</body>
</html>