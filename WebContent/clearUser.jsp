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
<link rel="stylesheet" href="./css/clear.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>退会画面</title>

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

<script>

	function deleteCheck(){if(window.confirm('退会いたします。よろしいですか？')){

		return true
		}else{
		return false;

	}

	}


	</script>




<table>
<s:form action="ClearUserCompleteAction" cssClass="form">
<tr><td colspan="2"><h3>退会処理画面</h3></td></tr>
<tr><td colspan="2"><hr></td></tr>
<tr><td colspan="2"><div class="moji">退会の処理を行います。</div></td></tr>
<tr><td colspan="2"><div class="moji">ー注意事項ー</div></td></tr>

<tr>
<td colspan="2">・ご登録して頂いたお客様のユーザー情報は全て削除されます。</td>
</tr>
<tr>
<td colspan="2">・ユーザー情報の復元は承りかねますのであらかじめご了承ください。</td>
</tr>
<tr>
<td colspan="2">・あらためてご利用いただく場合は、はじめからご設定となりますのでご注意ください。</td>
</tr>


<tr><td colspan="2"><div class="moji">以上の注意点をご了承頂いた上で下記の同意欄にチェックをして頂きまして、退会ボタンで退会処理を行ってください。</div></td></tr>


<tr><td><a href='<s:url action="MyPageAction"/>'><img class="icon2"  src="./images/icon/modoru2.png"></a></td>
<td><div class="btn1">同意する
		<input id="checkBtn" type="checkbox"><br>
		<input type="hidden" name="clearFlg" value="clearFlg"/>
		<input id="submitBtn"  disabled="disabled" type="image" src="./images/icon/taikai.png" value="退会する"  class="icon1" onclick="return deleteCheck();">
	</div></td></tr>

</s:form>
</table>



</div>


<jsp:include page="include_footer.jsp"/>

</body>
</html>