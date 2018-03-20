<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css"/>
<link rel="stylesheet" href="./css/alatanapizza.css">
<title>退会画面</title>
<style>
.moji {
	    text-align: center;
	    font-size: 12px;
	    color: #FFCC33;
	    }
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
<s:form action="ClearUserCompleteAction">
<h2>退会処理画面</h2>
<div class="moji">退会の処理を行います。</div>
<div class="moji">ー注意事項ー</div>
<ul>
<li>ご登録して頂いたお客様のユーザー情報は全て削除されます。</li>
<li>ユーザー情報の復元は承りかねますのであらかじめご了承ください。</li>
<li>あらためてご利用いただく場合は、はじめからご設定となりますのでご注意ください。</li>
<li>ご注文中の商品のキャンセルに関しましては退会処理の前に行っていただくようお願いいたします。</li>
</ul>
<div class="moji">以上の注意点をご了承頂いた上で下記の同意欄にチェックをして頂きまして、退会ボタンで退会処理を行ってください。</div>

<div class="btn1">
		<input id="checkBtn" type="checkbox">
		<input id="submitBtn" class="button" disabled="disabled" type="submit" value="退会する">
	</div>
</s:form>




</div>


<jsp:include page="include_footer.jsp"/>

</body>
</html>