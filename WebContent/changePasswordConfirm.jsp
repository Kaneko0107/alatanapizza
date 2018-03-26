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
<title>パスワード変更確認画面</title>
<script>
window.onunload=function(){};
history.forward();
</script>
<style>
.main{
width:50%;
background:rgba(0,0,0,0.5);
margin-top:30px;
margin-left:25%;
margin-bottom:30px;
}
h3 {
	border-left: 10px solid red;
}
.moji2{
text-align:left;
	    font-size: 20px;
	    color: #FFCC33;
}
.moji3{
text-align:right;
	    font-size: 20px;
	    color: #FFCC33;
}

.moji {
	    text-align: center;
	    font-size: 12px;
	    color: #FFCC33;
	    }
table {
	width: 80%;
	margin: 0 auto;
	text-align: left;
}
.aaa{
color:white;}
.image2 {

	    text-align:right;
		margin-bottom:10px;
	    }


hr {
	    text-align:left;
	    border:none;
	    border-top:dashed 1px #ccc;
	    height:1px;
	    color:#ffffff;
	    margin:0 8 0 8;
	    }

</style>
</head>
<body>
<jsp:include page="include_header.jsp" />
<div class="main">
<table>
<tr><td colspan="2"><h3>変更内容確認画面</h3></td></tr>
<tr><td colspan="2"><hr></td></tr>
<tr><td colspan="2"><div class="moji">変更内容が正しければ下記の完了ボタンで再設定を完了します。</div><br></td></tr>


<s:form action="ChangePasswordCompleteAction">

		 <tr>
		 <td><div class="moji3">変更後のパスワード:</div></td>
		 <td><div class="moji2"><s:property value="%{hideNewPassword}"/></div></td>
		 	<td><s:hidden name="newpass" value="%{newpass}" />
			<s:hidden name="userid" value="%{userid}" />
			<s:hidden name="secret_answer" value="%{secret_answer}"/>
			<s:hidden name="secret_question" value="%{secret_question}"/>
		</td>
</tr><br><br><br>

<tr><td colspan="2"><hr></td></tr>

			<td><a class="image3" href="javascript:history.back();"><img  class="icon" src="./images/icon/modoru2.png"></a></td>


<td><div class="image2"><input type="image" class="icon" src="./images/icon/登録する .png" alt="touroku"></div></td>
			</s:form>
<!--<s:form name="for" action="ChangePasswordAction">

			<s:hidden name="newpass" value="%{newpass}" />
			<s:hidden name="userid" value="%{userid}" />
			<s:hidden name="secret_answer" value="%{secret_answer}"/>
			<s:hidden name="secret_question" value="%{secret_question}"/>
			</s:form>-->
</table>
</div>
<jsp:include page="include_footer.jsp"/>

</body>
</html>