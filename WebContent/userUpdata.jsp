<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="title"><p>ユーザー情報変更<p></div>
<div>ユーザー情報を変更してください</div>
<div>以前の情報を保持したい箇所は空欄のまま先へ進んでください</div>
<s:form action="UserUpdateConfirmAction">
<table>


   <tr>
   <th>ユーザーID</th>
   <td><s:property value="%{session.user_id}" />
   <s:hidden name="user_id" value="%{session.user_id}"/>
   </td>
   </tr>
   <tr>
   <th>現在のパスワード</th>
   <td><s:password name="password" placeholder="1～16文字の半角英数字"/></td>
   </tr>
   <tr>
   <th>新規パスワード</th>
   <td><s:password name="newPassword" placeholder="1～16文字の半角英数字"/></td>
   </tr>
   <tr>
   <th>確認用パスワード</th>
   <td><s:password name="conPassword" placeholder="確認のため再入力"/></td>
   </tr>
   <tr>
   <th>メールアドレス</th>
   <td><s:textfield name="newEmail" placeholder="10文字以上32文字以下"/></td>
   </tr>
   </table>
   <div>
   <s:a href="javascrrpt:void(0)"
	onclick="document.UserUpdateConfirmAction.submit();return false;"
	 class="button">登録</s:a>
   </div>
   <br>
   <s:if test="errorMessage!=''">
   <s:iterator value="errMsgList">
		<h5>
			<s:div align="center">
				<s:property />
			</s:div>
		</h5>
		</s:iterator>
		</s:if>
   </s:form>

</body>
</html>