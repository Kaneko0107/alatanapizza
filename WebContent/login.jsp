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
<title>alatanapizza Login画面</title>
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
			<h3>会員の方のログイン</h3>
			<s:form action="LoginAction">
				<div>ID</div><!-- アラート化できたらしたい -->
				<s:textfield type="text" placeholder="1文字以上8文字以下" name="userId" value ="%{#session.saveId}"/>
				<br>
				<label><s:checkbox name ="saveLogin"/>
				ID保存</label>
				<div>パスワード</div>
				<s:password placeholder="1文字以上8文字以下" name="password"/>

				<br>
				<s:hidden name ="kessai" value ="%{kessai}"/>
				<s:submit value="ログイン"/>

			</s:form>
		</div>
		<br/>
		<div>
			<span>ホーム画面は
					<a href='<s:url action="HomeAction"/>'>こちら</a>
			</span>
		</div>
		<br/>
	  	<div>
		<span>パスワードを忘れた方は
					<a href='<s:url action="ChangePasswordAction"/>'>こちら</a>
			</span>
		</div>
		<br/>
		<div>
			<span>新規ユーザー登録は
				<a href='<s:url action="UserCreateAction"/>'>こちら</a>
			</span>
		</div>

		<a href="javascript:void(0)" onclick="javascript:history.back()">戻る</a>
	</div>
<jsp:include page="include_footer.jsp" />
</body>
</html>