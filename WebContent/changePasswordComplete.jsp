<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<link rel="stylesheet" href="./css/userAdd.css">




<title>パスワード変更完了</title>

</head>
<body>
<jsp:include page="include_header.jsp" />
<div id="main">
<s:if test="#session.newpass == null">
<div class="error">パスワードの変更に失敗しました。<br>
お手数ですが最初からやり直してください。
</div>
<a href='<s:url action="ChangePasswordAction"/>'>再設定画面へ</a>
</s:if>
<s:else>
<br>
<table>
<tr><td><h3>再設定が完了しました。</h3></td></tr>

<tr>
	<td colspan="2"><hr></td></tr>
<tr>

		<td><div class="iconComplete"><a href='<s:url action="MyPageAction"/>'>マイページへ</a></div></td></tr>
		<tr>
		<td><div class="iconComplete"><a href='<s:url action="HomeAction"/>'>ホームへ</a></div></td>


	</tr>

	</table>




</s:else>
</div>
<jsp:include page="include_footer.jsp"/>


</body>
</html>