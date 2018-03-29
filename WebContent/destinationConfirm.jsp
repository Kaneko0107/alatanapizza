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
<title>宛先情報 確認</title>
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
width:70%;
background:rgba(0,0,0,0.5);
margin-top:70px;
margin-left:15%;
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

tr td .imagehover{text-align:center;
margin-top:40px;
}

tr td .memo{text-align:center;
}

.imagehover {
	clear:both;
	width: 250px;
	height: 140px;
	overflow: hidden;
}

.icon1{
position:relative;
left:20px;}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">


/* 	$(function(){
		$(".imagehover .image").hover(
		function(){
			$(this).animate({
				width:"250px"
			});
		},
		function(){
			$(this).animate({
				width:"180px"
			});
		});
	}); */
</script>

<script>
/* フォーム内にフォーム入れられないためこの形で実装 */
function goDestCompleteAction(){
	document.getElementById("form").action = "DestCompleteAction";
}
function goDestAction(){

	document.getElementById("form").action = "DestAction";
}
</script>

</head>
<body>

<jsp:include page="include_header.jsp" />
	<div id="top">
	</div>

	<div id="main">
			<table>
<s:form id="form" class="form">



			<tr>
				<td colspan="2"><h3>以下の内容で登録します</h3></td>
			</tr>

<!--  白い点線 -->
			<tr>
				<td colspan="2"><hr></td>
			</tr>



<!-- 姓 -->
				<tr>
					<td>-姓-</td>
				</tr>
				<tr>
					<td><s:property value="familyName" escape="false"/>
					<input type=hidden name="familyName" value='<s:property value="familyName"/>' /></td>
				</tr>

<!-- 名 -->
				<tr>
					<td>-名-</td>
				</tr>
				<tr>
					<td><s:property value="firstName" escape="false"/>
					<input type=hidden name="firstName" value='<s:property value="firstName"/>' /></td>
				</tr>

<!-- 姓かな -->
				<tr>
					<td>-姓（かな）-</td>
				</tr>
				<tr>
					<td><s:property value="familyNameKana" escape="false"/>
					<input type=hidden name="familyNameKana" value='<s:property value="familyNameKana"/>' /></td>
				</tr>

<!-- 名かな -->
				<tr>
					<td>-名（かな）-</td>
				</tr>
				<tr>
					<td><s:property value="firstNameKana" escape="false"/>
					<input type=hidden name="firstNameKana" value='<s:property value="firstNameKana"/>' /></td>
				</tr>

<!-- 郵便番号 -->
				<tr>
					<td>-郵便番号-</td>
				</tr>
				<tr>
					<td><s:property value ="zip11" escape ="false"/>
					<input type =hidden name ="zip11" value ='<s:property value ="zip11"/>' /></td>
				</tr>


<!-- 住所 -->
				<tr>
					<td>-住所-</td>
				</tr>
				<tr>
					<td><s:property value="addr11" escape="false"/>
					<input type=hidden name="addr11" value='<s:property value="addr11"/>' /></td>
				</tr>

<%-- <!-- 住所 -->
				<tr>
					<td>-住所-</td>
				</tr>
				<tr>
					<td><s:property value="userAddress" escape="false"/>
					<input type=hidden name="userAddress" value='<s:property value="userAddress"/>' /></td>
				</tr> --%>

<!-- 電話番号 -->
				<tr>
					<td>-電話番号-</td>
				</tr>
				<tr>
					<td><s:property value="telNumber" escape="false"/>
					<input type=hidden name="telNumber" value='<s:property value="telNumber"/>' /></td>
				</tr>

<!-- メールアドレス -->
				<tr>
					<td>-メールアドレス-</td>
				</tr>
				<tr>
					<td><s:property value="email" escape="false"/>
					<input type=hidden name="email" value='<s:property value="email"/>' /></td>
				</tr>

<!--  白い点線 -->
			<tr>
				<td colspan="2"><hr></td>
			</tr>



<!-- 戻る画像アイコン -->

<tr>
	<td>
	<s:submit class="memo icon" type="image" value="" src="./images/icon/modoru2.png" onclick="goDestAction();" />
	</td>
<!-- 送信画像アイコン -->
	<td>
	<s:submit class="icon1" type="image" value="" src="./images/icon/touroku.png" onclick="goDestCompleteAction();" />
	</td>
</tr>

<!--     	<tr><td><div class="memo"><a href="javascript:void(0)" onclick="javascript:history.back()"><img src="./images/icon/modoru2.png"></a></div></td></tr> -->


</s:form>
		</table>
		</div>

<div class="footer">
<jsp:include page="include_footer.jsp" />
</div>

</body>
</html>