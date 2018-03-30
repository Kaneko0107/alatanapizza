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
	width:50%;
	background:rgba(0,0,0,0.5);
	margin-top:70px;
	margin-left:25%;
	margin-bottom:30px;
}

/*========CLASS LAYOUT========*/

.form {
	background-color: rgba(200, 200, 200, 0.5);
	width: 100%;
	height: 30px;
	border-radius: 5px;
	color:black;
}

table{
width:60%;
}


.memo{float:right;
}

.imagehover{
	clear:both;
	width: 150px;
	height: 150px;
	overflow: hidden;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./js/jquery-1.8.2.min.js"></script>
<script src="https://ajaxzip3.github.io/ajaxzip3.js" charset="UTF-8"></script>

<script type="text/javascript">


/* 全角→半角に自動変換する */
$(function(){
    $(".zenkakuTOhankaku").blur(function(){
        charChange($(this));
    });


    charChange = function(e){
        var val = e.val();
        var str = val.replace(/[Ａ-Ｚａ-ｚ０-９]/g,function(s){return String.fromCharCode(s.charCodeAt(0)-0xFEE0)}).replace(/[‐－―]/g, '-').replace(/[＠]/g, '@').replace(/[．]/g, '.');

        if(val.match(/[Ａ-Ｚａ-ｚ０-９‐－―＠．]/g)){
            $(e).val(str);
        }

    }
});


</script>
<style>

.test{
color:red;
font-size:15px;
}
</style>

</head>

<header>
	<jsp:include page="include_header.jsp" />
</header>


<body>
	<div id="main">

	<br>


		<table>
			<tr>
				<td><h3>新規宛先情報入力</h3></td>
			</tr>
<!--  白い点線 -->
			<tr>
				<td><hr></td>
			</tr>

			<tr>
				<td><span class="test"><s:if test="destinationList != null">宛先が登録されていないため、</s:if></span></td>
			</tr>
			<tr>
				<td><h4>下記に必要事項を記入してください</h4></td>
			</tr>

			<s:form action="DestConfirmAction">

				<tr>
					<td><div style="color: red;" ><s:iterator value="errorMessageList"><s:div align="center"><s:property/></s:div></s:iterator></div></td>
				</tr>

<!-- 姓 -->
				<tr>
					<td>姓 [半角英語、漢字、ひらがな]</td>
				</tr>
				<tr>
					<td><s:textfield class ="form zenkakuTOhankaku" placeholder="1文字以上16文字以下" name="familyName" maxlength ='16' value="%{familyName}" /></td>
				</tr>

<!-- 名 -->
				<tr>
					<td>名 [半角英語、漢字、ひらがな]</td>
				</tr>
				<tr>
					<td><s:textfield class ="form zenkakuTOhankaku" placeholder="1文字以上16文字以下" name="firstName" maxlength ='16' value="%{firstName}" /></td>
				</tr>

<!-- 姓かな -->
				<tr>
					<td>姓（かな）[ひらがな]</td>
				</tr>
				<tr>
					<td><s:textfield class ="form" placeholder="1文字以上16文字以下" name="familyNameKana" maxlength ='16' value="%{familyNameKana}" /></td>
				</tr>

<!-- 名かな -->
				<tr>
					<td>名（かな）[ひらがな]</td>
				</tr>
				<tr>
					<td><s:textfield class ="form" placeholder="1文字以上16文字以下" name="firstNameKana" maxlength ='16' value="%{firstNameKana}" /></td>
				</tr>

<!-- 郵便番号 -->
				<tr>
					<td>郵便番号 [半角数字]</td>
				</tr>
				<tr>
					<td><s:textfield class ="form zenkakuTOhankaku" placeholder="7文字以上8文字以下" name="zip11" size ="10" maxlength ='8' value="%{zip11}" onKeyUp="AjaxZip3.zip2addr(this,'','addr11','addr11');" /></td>
				</tr>

<!-- 住所 -->
				<tr>
					<td>住所</td>
				</tr>
				<tr>
					<td>[半角英数字記号、漢字、ひらがな、カタカナ]</td>
				</tr>
				<tr>
					<td><s:textfield class ="form zenkakuTOhankaku" placeholder="15文字以上50文字以下" name="addr11" maxlength ='50' value="%{addr11}" /></td>
				</tr>


<!-- 電話番号 -->
				<tr>
					<td>電話番号 [半角数字「-」ハイフン]</td>
				</tr>
				<tr>
					<td><s:textfield class ="form zenkakuTOhankaku" placeholder="11文字以上13文字以下" name="telNumber" maxlength ='13' value="%{telNumber}"  /></td>
				</tr>

<!-- メールアドレス -->
				<tr>
					<td>メールアドレス [半角英数字記号]</td>
				</tr>
				<tr>
					<td><s:textfield class ="form zenkakuTOhankaku" placeholder="14文字以上32文字以下" name="email" maxlength ='32' value="%{email}"  /></td>
				</tr>


<!--  白い点線 -->
			<tr>
				<td><hr></td>
			</tr>


<!-- 戻る画像アイコン -->
			<tr>
				<td><s:if test="destinationList != null"><a href='<s:url action="CartProductAction"/>'><span class="imagehover"><img class="icon" src="./images/icon/modoru2.png"></span></a></s:if>
					<s:else><a href='<s:url action="BuyItemCompleteAction"/>'><span class="imagehover"><img class="icon" src="./images/icon/modoru2.png"></span></a></s:else>

<!-- 送信画像アイコン -->
				<span class="memo"><span class="imagehover"><s:submit class="icon" type="image" value="" src="./images/icon/kakuninn.png"/></span></span></td>
			</tr>

			</s:form>


		</table>

	</div>

</body>

<footer>
	<jsp:include page="include_footer.jsp" />
</footer>

</html>