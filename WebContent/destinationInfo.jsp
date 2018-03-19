<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content="">
<meta name="keywords" content=""/>
<title>alatanapizza 宛先情報登録画面</title>
<style type="text/css">
/*========TAG LAYOUT========*/

h3{
border-left:10px solid red;
}

hr{border: none;
	border-top: dashed 1px #ccc;
	height: f1px;
	color: #ffffff;
	margin: 0 8 0 8;
}

/*========ID LAYOUT========*/

#main{
	width:50%;
	background:rgba(0,0,0,0.5);
	margin-top:70px;
	margin-left:25%;
	margin-bottom:30px;
}

table{
	margin:0 auto;
	text-align: left;
	padding-left: 20%;
	padding-right: 20%;
}

/*========CLASS LAYOUT========*/

.form {
	background-color: rgba(200, 200, 200, 0.5);
	width: 270px;
	height: 30px;
	border-radius: 5px;
	color:black;
}

tr td .memo{text-align:center;
}

</style>
</head>

<body>
<jsp:include page="include_header.jsp" />

	<div id="top">
	</div>

	<div id="main">

	<br>


		<table>
			<tr>
				<td><h3>新規宛先情報入力</h3></td>
			</tr>
<!--  白い点線 -->
			<tr><td><hr></td></tr>

			<tr>
				<td><h4>下記に必要事項を記入してください</h4></td>
			</tr>



			<s:form action="DestConfirmAction">
			<table>
				<tr><td><div style="color: red;" ><s:iterator value="errorMessageList"><s:div align="center"><s:property/></s:div></s:iterator></div></td></tr>

				<tr><td>姓</td></tr>
				<tr><td><s:textfield class ="form" placeholder="1文字以上16文字以下" name="familyName" value="%{familyName}" /></td></tr>
				<tr><td>名</td></tr>
				<tr><td><s:textfield class ="form" placeholder="1文字以上16文字以下" name="firstName" value="%{firstName}" /></td></tr>
				<tr><td>姓(かな)</td></tr>
				<tr><td><s:textfield class ="form" placeholder="1文字以上16文字以下" name="familyNameKana" value="%{familyNameKana}" /></td></tr>
				<tr><td>名(かな)</td></tr>
				<tr><td><s:textfield class ="form" placeholder="1文字以上16文字以下" name="firstNameKana" value="%{firstNameKana}" /></td></tr>
				<tr><td>住所</td></tr>
				<tr><td><s:textfield class ="form" placeholder="15文字以上50文字以下" name="userAddress" value="%{userAddress}" /></td></tr>
				<tr><td>電話番号</td></tr>
				<tr><td><s:textfield class ="form" placeholder="11文字以上13文字以下" name="telNumber" value="%{telNumber}" /></td></tr>
				<tr><td>メールアドレス</td></tr>
				<tr><td><s:textfield class ="form" placeholder="18文字以上32文字以下" name="email" value="%{email}" /></td></tr>
				<tr><td><s:submit value="登録情報確認画面へ"/></td></tr>
			</table>
			</s:form>


<!--  白い点線 -->
			<tr><td><hr></td></tr>


			<tr><td><div class="memo"><a href="javascript:void(0)" onclick="javascript:history.back()">◀ 戻る</a></div></td></tr>

		</table>



	</div>
	<div id ="footer">
	<jsp:include page="include_footer.jsp" />
	</div>
</body>


</html>