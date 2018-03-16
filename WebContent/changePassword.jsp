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
.error{
color:white;}
.error1{
coror:white;}


</style>
</head>
<body>
<jsp:include page="include_header.jsp" />
<p>パスワード変更画面</p>
<p>お客様が以前登録されたユーザーIDと秘密の質問からパスワードを変更します。</p>
<p>指定に従って以下の項目を入力し、下記の確認ボタンを押してください。</p>

<s:if test="errorMessage!=''">
   <s:iterator value="errMsgList">
		<h5>
			<s:div align="center">
				<s:property />
			</s:div>
		</h5>
		</s:iterator>
		</s:if>
<s:form action="ChangePasswordConfirmAction" >
<table>
<tr>
<td>ユーザーID;</td>
<td><input type="text" value='<s:property value="userid"/>' name="userid" placeholder="1～8文字以内半角英数字"/></td>
</tr>
<tr>
<td>秘密の質問:</td>
<td> <s:if test="secret_question==1">
            <select name="secret_question">
              <option value="">選択してください</option>
              <option value="1" selected>好きな食べ物</option>
              <option value="2">嫌いな食べ物</option>
            </select>
          </s:if>

          <s:elseif test="secret_question==2">
            <select name="secret_question">
              <option value="">選択してください</option>
              <option value="1">好きな食べ物</option>
              <option value="2" selected>嫌いな食べ物</option>
            </select>
          </s:elseif>

          <s:else>
            <select name="secret_question">
              <option value="">選択してください</option>
              <option value="1">好きな食べ物</option>
              <option value="2">嫌いな食べ物</option>
            </select>
          </s:else>
</td>
</tr>
<tr>
<td>答え:</td>
<td><input type="text" name="secret_answer" value='<s:property value="secret_answer"/>'  /></td>
</tr>
<tr>
<td>新しいパスワード:</td>
<td><input type="password" name="newpass" placeholder="1～16文字以内の半角英数字"/></td>
</tr>
<tr>
<td>確認:</td>
<td><input type="password" name="checkpass" placeholder="1～16文字以内の半角英数字"/></td>
</tr>
<tr>
<td><s:submit value="確認"/></td>
</tr>
</table>


</s:form>

<a href='<s:url action="LoginAction"/>'>ログインページへ戻る</a>

<jsp:include page="include_footer.jsp"/>


</body>
</html>