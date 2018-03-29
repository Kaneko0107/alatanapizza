<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<link rel="stylesheet" href="./css/userAdd.css">
<title>パスワード変更確認画面</title>
<script>
window.onunload=function(){};
history.forward();
</script>

</head>
<body>
<jsp:include page="include_header.jsp" />
<div id="main">
<div class="center">
<table>
<tr><td colspan="2"><h3>変更内容確認画面</h3></td></tr>
<tr><td colspan="2"><hr></td></tr>
<tr><td colspan="2"><div class="moji">変更内容が正しければ下記の完了ボタンで再設定を完了します。</div><br></td></tr>


<s:form action="ChangePasswordCompleteAction">

		 <tr>
		 <td colspan="2"class="moji2"><span class="moji3">変更後のパスワード:<s:property value="%{hideNewPassword}"/></span>
		 <s:hidden name="newpass" value="%{newpass}" />
			<s:hidden name="userid" value="%{userid}" />
			<s:hidden name="secret_answer" value="%{secret_answer}"/>
			<s:hidden name="secret_question" value="%{secret_question}"/></td>

</tr>

<tr><td colspan="2"><hr></td></tr>

			<tr><td><div class="image1"><a href="javascript:history.back();"><img  class="icon2" src="./images/icon/modoru2.png"></a></div></td>


<td class="image2"><input type="image" class="icon2" src="./images/icon/登録する .png" alt="touroku"></td></tr>
			</s:form>

</table>
</div>
</div>
<jsp:include page="include_footer.jsp"/>

</body>
</html>