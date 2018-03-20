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
<title>alatanapizza Login画面</title>
<style type="text/css">
/*========TAG LAYOUT========*/

table{
	margin:0 auto;
	text-align: left;
	padding-left: 20%;
	padding-right: 20%;
}

image{text-align:center;
}

hr{border: none;
	border-top: dashed 1px #ccc;
	height: f1px;
	color: #ffffff;
	margin: 0 8 0 8;}

h3{
border-left:10px solid red;
}

/*========ID LAYOUT========*/

#main{
width:50%;
background:rgba(0,0,0,0.5);
margin-top:70px;
margin-left:25%;
margin-bottom:30px;
}

/*========CLASS LAYOUT========*/

.id {text-align:right;
	}

.form {
	background-color: rgba(200, 200, 200, 0.5);
	width: 270px;
	height: 30px;
	border-radius: 5px;
	color:black;
}

tr td .login{text-align:center;
margin-top:40px;
}

tr td .memo{text-align:center;
}

.login {
 clear:both;
 width: 300px;
  height: 140px;
  overflow: hidden;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./js/jquery-1.8.2.min.js"></script>
<script>
	$(function(){
		$(".login .image").hover(
		function(){
			$(this).animate({
				width:"300px"
			});
		},
		function(){
			$(this).animate({
				width:"238px"
			});
		});
	});
</script>
</head>

<body>
<jsp:include page="include_header.jsp" />
		<div id="top">
		</div>

		<div id="main">

		<br>



			<!-- テーブルはじまり -->
			<table>
			<tr><td><h3>会員の方のログイン</h3></td></tr>

<!--  白い点線 -->
			<tr><td><hr></td></tr>

			<s:form action="LoginAction">

			<tr><td><div style="color: red;" ><s:iterator value="errorMessageList"><s:div align="center"><s:property/></s:div></s:iterator></div></td></tr>

<!-- ID -->
			<tr><td>ID</td></tr>
			<tr><td><s:textfield type="text" class="form" placeholder="1文字以上8文字以下" name="userId" value ="%{#session.saveId}"/></td></tr>

<!-- パスワード -->
			<tr><td><div class="id"><label><s:checkbox name ="saveLogin"/>ID保存</label></div></td></tr>

			<tr><td>パスワード</td></tr>
			<tr><td><s:password class="form" placeholder="1文字以上8文字以下" name="password"/></td></tr>

			<tr><td><s:hidden name ="kessai" value ="%{kessai}"/></td></tr>
<!-- ログインボタン -->
<!-- マウスオーバーの設定と、真ん中に配置してください -->
			<tr><td><div class="login"><s:submit class="image" type="image" value="" src="./images/icon/ログイン.png"/></div></td></tr>


			</s:form>




			<!--  白い点線 -->
			<tr><td><hr></td></tr>

			<tr><td><div class="memo">ホーム画面は<a href='<s:url action="HomeAction"/>'>こちら</a>
				</div></td></tr>

			<tr><td><div class="memo">パスワードを忘れた方は<a href='<s:url action="ChangePasswordAction"/>'>こちら</a>
				</div></td></tr>

			<tr><td><div class="memo">新規ユーザー登録は<a href='<s:url action="UserCreateAction"/>'>こちら</a>
				</div></td></tr>

			<tr><td><div class="memo"><a href="javascript:void(0)" onclick="javascript:history.back()">◀ 戻る</a></div></td></tr>
				</table></div>


		<div id ="footer">
			<jsp:include page="include_footer.jsp" />
		</div>


</body>

</html>