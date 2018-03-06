<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>パスワード変更画面</h3>



			<p>ログインPASS:</p>
			<s:property value="newpass" escape="false" />
			<input type="hidden" value="%{newpass}" /> <input type="hidden"
				value="%{userid}" /> <input type="hidden" value="%{answer}" />



			<s:form action="ChangePasswordCompleteAction">
				<s:submit value="完了" />
			</s:form>



</body>
</html>