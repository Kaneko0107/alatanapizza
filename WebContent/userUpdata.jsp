<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="include_header.jsp" />
<div id="title"><p>ユーザー情報変更<p></div>
<div>ユーザー情報を変更してください</div>
<div>現在のパスワードは必ず入力してください</div>
<div>以前の情報を保持したい箇所は空欄のまま先へ進んでください</div>
 <s:if test="errorMessage!=''">
   <s:iterator value="errMsgList">
		<h5>
			<s:div align="center">
				<s:property />
			</s:div>
		</h5>
		</s:iterator>
		</s:if>
<s:form action="UserUpdateConfirmAction">
<table>


   <tr>
   <th>ユーザーID</th>
   <td><s:property value="%{session.userId}" />
   <s:hidden name="user_id" value="%{session.userId}"/>
   </td>
   </tr>
   <tr>
   <th>現在のパスワード</th>
   <td><s:password name="password" placeholder="1～16文字の半角英数字" required="true"/></td>
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
   <td><s:textfield name="newEmail" placeholder="14文字以上32文字以下"/></td>
   </tr>
   </table>
   <div>
   <s:a href="javascrrpt:void(0)"
	onclick="document.UserUpdateConfirmAction.submit();return false;"
	 class="button">登録</s:a>
   </div>
   <br>

   </s:form>
   <jsp:include page="include_footer.jsp"/>

</body>
</html>