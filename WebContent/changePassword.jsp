<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>パスワード変更画面</title>
<style>
.error{
color:white;}
.error1{
coror:white;}
.main{
width:70%;
height:80%
background:rgba(0,0,0,0.5);
margin-top:70px;
margin-left:15%;
margin-bottom:30px;
}


table {
	width: 80%;
	margin: 0 auto;
	text-align: left;
	padding-left:20px;
}

h3 {
	border-left: 10px solid red;
}

::-webkit-input-placeholder {
  color:#000000;
}

::-moz-placeholder {
 color:#000000;
 opacity: 1;
}

/* Internet Explorer 10-11 */
:-ms-input-placeholder {
 color:#000000;
}



.moji {
	    text-align: center;
	    font-size: 12px;
	    color: #FFCC33;
	    }

.error{
color:red;
text-align:center;
font-weight:900;
 font-size: 12px;
}


.form {
	background-color: rgba(200, 200, 200, 0.5);
	width: 200px;
	height: 30px;
	border-radius: 5px;
	color:black;
}

tr td {
	padding-right: 30px;
	padding-left: 20px;
	padding-top: 5px;
}

hr {
	text-align: left;
	border: none;
	border-top: dashed 1px #ccc;
	height: 1px;
	color: #ffffff;
	margin: 0 8 0 8;
}


.image2 {

	    text-align:right;
	    margin-top: 5px;
	    }




</style>
</head>
<body>
<jsp:include page="include_header.jsp" />
<div class="main">
<table>
<tr><td colspan="2"><h3>パスワード変更画面</h3></td></tr>
<tr><td colspan="2"><hr></td></tr>
<tr><td colspan="2"><div class="moji">お客様が以前登録されたユーザーIDと秘密の質問からパスワードを変更します</div></td></tr>
<tr><td colspan="2"><div class="moji">指定に従って以下の項目を入力し、下記の確認ボタンを押してください</div><br></td></tr>

<s:if test="errorMessage!=''">
   <s:iterator value="errMsgList">

			<tr><td colspan="2"><div class="error">
				<s:property />
		</div></td></tr>

		</s:iterator>
		</s:if>

<s:form action="ChangePasswordConfirmAction" >

<tr>
<td>ユーザーID;</td>
<td>
<s:if test="#session.saveId != null">
<input type="text" value='<s:property value="#session.saveId"/>' name="userid" placeholder="1～8文字以内半角英数字" class="form"/>
</s:if>
<s:else>
<input type="text" value='<s:property value="userid"/>' name="userid" placeholder="1～8文字以内半角英数字" class="form"/>
</s:else>
</td>
</tr>
<tr>
<td>秘密の質問:</td>
<td> <s:if test="secret_question==1">
            <select name="secret_question" class="form">
              <option value="">選択してください</option>
              <option value="1" selected>好きな食べ物</option>
              <option value="2">嫌いな食べ物</option>
            </select>
          </s:if>

          <s:elseif test="secret_question==2">
            <select name="secret_question" class="form">
              <option value="">選択してください</option>
              <option value="1">好きな食べ物</option>
              <option value="2" selected>嫌いな食べ物</option>
            </select>
          </s:elseif>

          <s:else>
            <select name="secret_question" class="form">
              <option value="">選択してください</option>
              <option value="1">好きな食べ物</option>
              <option value="2">嫌いな食べ物</option>
            </select>
          </s:else>
</td>
</tr>
<tr>
<td>答え:</td>
<td><input type="text" name="secret_answer" value='<s:property value="secret_answer"/>'  class="form"/></td>
</tr>
<tr>
<td>新しいパスワード:</td>
<td><input type="password" name="newpass" placeholder="1～16文字以内の半角英数字" class="form"/></td>
</tr>
<tr>
<td>確認:</td>
<td><input type="password" name="checkpass" placeholder="1～16文字以内の半角英数字" class="form"/></td>
</tr>
<tr><td colspan="2"><hr></td></tr>
<tr>
<td>
<div class="image1"><a href='<s:url action="LoginAction"/>'><img class="icon" src="./images/icon/modoru2.png"></a></div>
</td><td>
<div class="image2"><input class="icon" type="image" src="./images/icon/kakuninn.png" alt=""></div></td>
</tr>

</s:form>


</table>
</div>
<jsp:include page="include_footer.jsp"/>


</body>
</html>