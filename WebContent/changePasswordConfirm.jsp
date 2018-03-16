<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>Insert title here</title>
<style>
.aaa{
color:white;}
</style>
</head>
<body>
<jsp:include page="include_header.jsp" />
<h3>変更内容確認画面</h3><br>
<p>変更内容が正しければ下記の完了ボタンで再設定を完了します。</p>


<s:form action="ChangePasswordCompleteAction">

		 <tr>
		<td>変更後のパスワード:</td>
		 <td><s:property value="%{hideNewPassword}"/></td>
		 	<td><s:hidden name="newpass" value="%{newpass}" />
			<s:hidden name="userid" value="%{userid}" />
			<s:hidden name="secret_answer" value="%{secret_answer}"/>
		</td>
</tr><br>

<tr>
				<td><s:submit value="完了" /></td>
				</tr>
			</s:form>

<jsp:include page="include_footer.jsp"/>

</body>
</html>