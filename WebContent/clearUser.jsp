<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="imagetoolbar" content="text/javascript"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
window.onunload=function(){};
history.forward();
</script>
<title>退会画面</title>
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
	    font-size: 17px;
	    color: #FFCC33;
	    }




tr td {
	padding-right: 30px;
	padding-left: 20px;
	padding-top: 5px;
}


.btn1{
 text-align:center;
	    margin-top: 5px;}
</style>

</head>
<body>
<jsp:include page="include_header.jsp" />

<div class="main">
<script type="text/javascript">
	$(function(){
		$('#checkBtn').on('change',function(){
			if($(this).is(':checked')){
				//チェックが入ったら、送信ボタンを押せる
				$('#submitBtn').prop('disabled',false);
			}else{
				//チェックが入っていなかったら、送信ボタンを押せない
				$('#submitBtn').prop('disabled',true);
			}
		});
	});
	</script>
<table>
<s:form action="ClearUserCompleteAction" cssClass="form">
<tr><td colspan="2"><h3>退会処理画面</h3></td></tr>
<tr><td colspan="2"><hr></td></tr>
<tr><td colspan="2"><div class="moji">退会の処理を行います。</div></td></tr>
<tr><td colspan="2"><div class="moji">ー注意事項ー</div><br></td></tr>

<tr>
<td>・ご登録して頂いたお客様のユーザー情報は全て削除されます。</td>
</tr>
<tr>
<td>・ユーザー情報の復元は承りかねますのであらかじめご了承ください。</td>
</tr>
<tr>
<td>・あらためてご利用いただく場合は、はじめからご設定となりますのでご注意ください。</td>
</tr>
<tr>
<td>・ご注文中の商品のキャンセルに関しましては退会処理の前に行っていただくようお願いいたします。</td>
</tr>


<tr><td><div class="moji">以上の注意点をご了承頂いた上で下記の同意欄にチェックをして頂きまして、退会ボタンで退会処理を行ってください。</div></td></tr>


<tr><td><div class="btn1">
		<input id="checkBtn" type="checkbox">
		<input id="submitBtn" class="button" disabled="disabled" type="submit" value="退会する">
	</div></td></tr>

</s:form>
</table>



</div>


<jsp:include page="include_footer.jsp"/>

</body>
</html>