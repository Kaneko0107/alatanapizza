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
<title>ログイン</title>
<style type="text/css">
/*========TAG LAYOUT========*/

table{
	margin:0 auto;
	text-align: left;
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



/* placeholderが見えづらいので色指定 */
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


/*========ID LAYOUT========*/

#main{
width:70%;
background:rgba(0,0,0,0.5);
margin-top:60px;
margin-left:15%;
margin-bottom:30px;
}

/*========CLASS LAYOUT========*/

.id {text-align:right;
	}

.form {
	background-color: rgba(200, 200, 200, 0.5);
	width: 100%;
	height: 30px;
	border-radius: 5px;
	color:black;
}

tr td .memo{text-align:center;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./js/jquery-1.8.2.min.js"></script>
<script>

/* 全角では入力できないように */

 	function checkForm($this){
 		var str = $this.value;
 		if(str.match(/[^A-Z^a-z0-9]+/)){
 			alert('IDは半角英数字で入力してください。');
 			$this.value = "";
 		}
 	}

</script>
</head>


<header>
	<jsp:include page="include_header.jsp" />
</header>

<body>
		<div id="main">

			<!-- テーブルはじまり -->
			<table>
			<tr>
				<td>
					<h3>会員の方のログイン</h3>
				</td>
			</tr>

<!--  白い点線 -->
			<tr>
				<td>
					<hr>
				</td>
			</tr>

			<s:form action="LoginAction">

			<tr>
				<td>
					<div style="color: red;" ><s:iterator value="errorMessageList"><s:div align="center"><s:property/></s:div></s:iterator></div>
				</td>
			</tr>

<!-- ID -->
			<tr>
				<td>
					ID [半角英数字]
				</td>
			</tr>
			<tr>
				<td>
					<s:textfield type="text" id="inputUserId" class="form" placeholder="1文字以上8文字以下" name="userId" maxlength ='8' value ="%{#session.saveId}" style="ime-mode:disabled" onInput="checkForm(this)" oncopy="return false" onpaste="return false" oncontextmenu="return false" />
				</td>
			</tr>

<!-- ID保存 -->
			<tr>
				<td>
					<s:if test ="%{#session.saveId != null}"><div class="id"><label><s:checkbox name ="saveLogin" checked ="checked"/>ID保存</label></div></s:if>
					<s:else><div class="id"><label><s:checkbox name ="saveLogin"/>ID保存</label></div></s:else>
				</td>
			</tr>

<!-- パスワード -->
			<tr>
				<td>
					パスワード [半角英数字]
				</td>
			</tr>
			<tr>
				<td>
					<s:password class="form" placeholder="1文字以上8文字以下" name="password" style="ime-mode:disabled" />
				</td>
			</tr>

			<tr>
				<td>
					<s:hidden name ="kessai" value ="%{kessai}"/>
				</td>
			</tr>
<!-- ログインボタン -->
			<tr>
				<td>
					<div class="memo"><s:submit class="icon" type="image" value="" src="./images/icon/ログイン.png"/></div>
				</td>
			</tr>

			</s:form>


<!--  白い点線 -->
			<tr>
				<td>
					<hr>
				</td>
			</tr>

<!-- リンク -->
			<tr>
				<td>
					<div class="memo">ホーム画面は<a href='<s:url action="HomeAction"/>'>こちら</a></div>
				</td>
			</tr>

			<tr>
				<td>
					<div class="memo">パスワードを忘れた方は<a href='<s:url action="ChangePasswordAction"/>'>こちら</a></div>
				</td>
			</tr>

			<tr>
				<td>
					<div class="memo">新規ユーザー登録は<a href='<s:url action="UserCreateAction"/>'>こちら</a></div>
				</td>
			</tr>

<!-- 戻る画像アイコン -->
			<tr>
				<td>
					<div class="memo"><a href="javascript:void(0)" onclick="javascript:history.back()"><img class="icon" src="./images/icon/modoru2.png"></a></div>
				</td>
			</tr>
				</table>

			</div>
</body>

<footer>
	<jsp:include page="include_footer.jsp" />
</footer>


</html>