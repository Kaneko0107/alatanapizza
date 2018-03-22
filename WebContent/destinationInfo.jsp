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
<title>宛先情報 登録</title>
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
	margin: 0 8 0 8;
}

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

.form {
	background-color: rgba(200, 200, 200, 0.5);
	width: 270px;
	height: 30px;
	border-radius: 5px;
	color:black;
}

tr td .image{text-align:center;
	margin-top:40px;
}

tr td .memo{text-align:center;
}

.imagehover{
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
		$(".imagehover .image").hover(
		function(){
			$(this).animate({
				width:"200px"
			});
		},
		function(){
			$(this).animate({
				width:"132px"
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

				<tr><td><div style="color: red;" ><s:iterator value="errorMessageList"><s:div align="center"><s:property/></s:div></s:iterator></div></td></tr>

<!-- 姓 -->
				<tr><td>姓 [1文字以上16文字以下 半角英語、漢字、ひらがな]</td></tr>
				<tr><td><s:textfield class ="form" placeholder="1文字以上16文字以下" name="familyName" maxlength ='16' value="%{familyName}" /></td></tr>
<!-- 名 -->
				<tr><td>名 [1文字以上16文字以下 半角英語、漢字、ひらがな]</td></tr>
				<tr><td><s:textfield class ="form" placeholder="1文字以上16文字以下" name="firstName" maxlength ='16' value="%{firstName}" /></td></tr>
<!-- 姓かな -->
				<tr><td>姓（かな）[1文字以上16文字以下 ひらがな]</td></tr>
				<tr><td><s:textfield class ="form" placeholder="1文字以上16文字以下" name="familyNameKana" maxlength ='16' value="%{familyNameKana}" /></td></tr>
<!-- 名かな -->
				<tr><td>名（かな）[1文字以上16文字以下 ひらがな]</td></tr>
				<tr><td><s:textfield class ="form" placeholder="1文字以上16文字以下" name="firstNameKana" maxlength ='16' value="%{firstNameKana}" /></td></tr>
<!-- 住所 -->
				<tr><td>住所 [14文字以上50文字以下 半角英数字記号、漢字、ひらがな、カタカナ]</td></tr>
				<tr><td><s:textfield class ="form" placeholder="15文字以上50文字以下" name="userAddress" maxlength ='50' value="%{userAddress}" /></td></tr>
<!-- 電話番号 -->
				<tr><td>電話番号 [11文字以上13文字以下(-含め) 半角数字]</td></tr>
				<tr><td><s:textfield class ="form" placeholder="11文字以上13文字以下" name="telNumber" maxlength ='13' value="%{telNumber}"  /></td></tr>
<!-- メールアドレス -->
				<tr><td>メールアドレス [18文字以上32文字以下 半角英数字記号]</td></tr>
				<tr><td><s:textfield class ="form" placeholder="18文字以上32文字以下" name="email" maxlength ='32' value="%{email}"  /></td></tr>

<!-- 送信画像アイコン -->
				<tr><td><div class="imagehover"><s:submit class="image" type="image" value="" src="./images/icon/kakuninn.png"/></div></td></tr>

			</s:form>


<!--  白い点線 -->
			<tr><td><hr></td></tr>

<!-- 戻る画像アイコン -->
			<tr><td><div class="memo"><a href="javascript:void(0)" onclick="javascript:history.back()"><img src="./images/icon/modoru2.png"></a></div></td></tr>

		</table>



	</div>
	<div id ="footer">
	<jsp:include page="include_footer.jsp" />
	</div>
</body>


</html>