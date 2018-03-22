<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>ユーザー情報変更画面</title>
<style>
table {
	width: 80%;
	margin: 0 auto;
	text-align: left;
}

h3 {
	border-left: 10px solid red;
}


.moji {
	    text-align: center;
	    font-size: 12px;
	    color: #FFCC33;
	    }

.form {
	background-color: rgba(200, 200, 200, 0.5);
	color:black;
	width: 200px;
	height: 30px;
	border-radius: 5px;
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
.touroku{
margin-top:20px;}
</style>
</head>
<body>
<jsp:include page="include_header.jsp" />
<table>
<tr><td colspan="2"><h3>ユーザー情報変更画面</h3></td></tr>
<tr><td colspan="2"><hr></td></tr>
<tr><td colspan="2"><div class="moji">お客様の登録されているパスワードから以下の項目を変更できます。</div></td></tr>
<tr><td colspan="2"><div class="moji">指定に従って以下の項目を入力し、下記の確認ボタンを押してください</div><br></td></tr>

<s:if test="errorMessage!=''">
   <tr><td colspan="2"><s:iterator value="errMsgList">

<div class="moji">
			<s:property />
</div>

		</s:iterator></td></tr>
		</s:if>
<s:form action="UserUpdateConfirmAction">



   <tr>
   <th>ユーザーID</th>
   <td><s:property value="%{session.userId}" />
   <s:hidden name="user_id" value="%{session.userId}"/>
   </td>
   </tr>
   <tr>
   <th>現在のパスワード</th>
   <td><s:password name="password" placeholder="1～16文字の半角英数字" class="form"/></td>
   </tr>
   <tr>
   <th>新規パスワード</th>
   <td><s:password name="newPassword" placeholder="1～16文字の半角英数字" class="form"/></td>
   </tr>
   <tr>
   <th>確認用パスワード</th>
   <td><s:password name="conPassword" placeholder="確認のため再入力" class="form"/></td>
   </tr>
   <tr>
   <th>メールアドレス</th>
   <td><s:textfield name="newEmail" placeholder="14文字以上32文字以下" class="form"/></td>
   </tr>

   <tr><td><a href='<s:url action="MyPageAction"/>'><img  src="./images/icon/modoru2.png"></a></td>
   <td><div class="image2">
   <s:a href="javascrrpt:void(0)"
	onclick="document.UserUpdateConfirmAction.submit();return false;"
	 class="button"><input class="touroku" type="image" src="./images/icon/kakuninn.png" alt="touroku"></s:a>
   </div></td></tr>
   <br>
   </s:form>
   </table>


   <jsp:include page="include_footer.jsp"/>

</body>
</html>